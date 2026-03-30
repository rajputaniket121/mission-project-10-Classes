package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * Controller for managing Student entities. Provides REST endpoints for CRUD
 * operations and preload data.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentDTO, StudentForm, StudentServiceInt> {

	@Autowired
	private CollegeServiceInt collegeService;

	/**
	 * Preloads college list for dropdown in student forms.
	 * 
	 * @return ORSResponse containing collegeList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<CollegeDTO> list = collegeService.search(new CollegeDTO(), userContext);
		res.addResult("collegeList", list);
		return res;
	}
}