package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

/**
 * Controller for managing Course entities. Provides REST endpoints for CRUD
 * operations on Course.
 * 
 * @author Aniket Rajput
 */
@RestController
@RequestMapping(value = "Course")
public class CourseCtl extends BaseCtl<CourseDTO, CourseForm, CourseServiceInt> {

}