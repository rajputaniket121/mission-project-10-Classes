
package com.rays.ctl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Jasper functionality Controller. Performs operation for Print pdf of
 * MarksheetMeriteList
 *
 * @author Aniket Rajput
 */
/**
 * The Class JasperCtl.
 * 
 */

@Transactional

@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetDTO, MarksheetForm, MarksheetServiceInt> {

	/** The session factory. */

//	  @Autowired 
	private SessionFactory sessionFactory = null;

	/** The context. */

	@Autowired
	ServletContext context;

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Display.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws JRException  the JR exception
	 * @throws SQLException the SQL exception
	 * @throws IOException  Signals that an I/O exception has occurred.
	 */
	@GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
	public void display(HttpServletResponse response)
	        throws JRException, SQLException, IOException {

	    InputStream reportStream =
	    		getClass().getClassLoader().getResourceAsStream("ORSProject10_Report.jrxml");

	    if (reportStream == null) {
	        throw new FileNotFoundException("ORSProject10_Report.jrxml jasper not found in classpath");
	    }

	    JasperReport jasperReport =
	            JasperCompileManager.compileReport(reportStream);

	    this.sessionFactory = entityManager.getEntityManagerFactory()
	            .unwrap(SessionFactory.class);

	    Connection con = sessionFactory
	            .getSessionFactoryOptions()
	            .getServiceRegistry()
	            .getService(ConnectionProvider.class)
	            .getConnection();

	    Map<String, Object> map = new HashMap<>();

	    JasperPrint jasperPrint =
	            JasperFillManager.fillReport(jasperReport, map, con);

	    byte[] pdf =
	            JasperExportManager.exportReportToPdf(jasperPrint);

	    response.setContentType("application/pdf");
	    response.setContentLength(pdf.length);
	    response.getOutputStream().write(pdf);
	    response.getOutputStream().flush();
	}

}