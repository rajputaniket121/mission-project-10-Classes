package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * Controller for managing Marksheet entities.
 * Provides REST endpoints for CRUD operations, roll number search, and merit list.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetDTO,MarksheetForm, MarksheetServiceInt> {

	@Autowired
	private StudentServiceInt studentService;

	/**
	 * Preloads student list for dropdown in marksheet forms.
	 * 
	 * @return ORSResponse containing studentList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<StudentDTO> list = studentService.search(new StudentDTO(), userContext);
		res.addResult("studentList", list);
		return res;
	}
	
	/**
	 * Finds marksheet by roll number.
	 * 
	 * @param rollNo the roll number to search for
	 * @return ORSResponse containing marksheet data if found, or error message if not found
	 */
	@GetMapping("rollno/{rollNo}")
	public ORSResponse rollNo(@PathVariable String rollNo) {
		ORSResponse res = new ORSResponse(true);
		MarksheetDTO dto = service.findByRollNo(rollNo, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}
	
	/**
	 * Gets the merit list of top performing students.
	 * 
	 * @return ORSResponse containing list of marksheets sorted by merit
	 */
	@GetMapping("meritlist")
	public ORSResponse getMeritList() {
		List<MarksheetDTO> list = service.getMeritList(userContext);
		ORSResponse res = new ORSResponse(true);
		res.addResult("list",list);
		return res;
	}
}