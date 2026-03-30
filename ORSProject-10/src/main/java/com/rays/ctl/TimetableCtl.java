package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimetableDTO;
import com.rays.form.TimetableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimetableServiceInt;

/**
 * Controller for managing Timetable entities.
 * Provides REST endpoints for CRUD operations and preload data.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Timetable")
public class TimetableCtl extends BaseCtl<TimetableDTO,TimetableForm, TimetableServiceInt> {
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	/**
	 * Preloads course and subject lists for dropdown in timetable forms.
	 * 
	 * @return ORSResponse containing courseList and subjectList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
	ORSResponse res = new ORSResponse(true);
	List<CourseDTO> list = courseService.search(new CourseDTO(), userContext);
	List<SubjectDTO> list1= subjectService.search(new SubjectDTO(), userContext);
	res.addResult("courseList", list);
	res.addResult("subjectList", list1);
	return res;
	}
}