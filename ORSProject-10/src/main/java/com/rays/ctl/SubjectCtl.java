package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.SubjectForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * Controller for managing Subject entities.
 * Provides REST endpoints for CRUD operations and preload data.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Subject")
public class SubjectCtl extends BaseCtl<SubjectDTO, SubjectForm, SubjectServiceInt> {

	@Autowired
	private CourseServiceInt courseService;

	/**
	 * Preloads course list for dropdown in subject forms.
	 * 
	 * @return ORSResponse containing courseList
	 */
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		List<DropdownList> list = courseService.search(new CourseDTO(), userContext);
		res.addResult("courseList", list);
		return res;
	}

}