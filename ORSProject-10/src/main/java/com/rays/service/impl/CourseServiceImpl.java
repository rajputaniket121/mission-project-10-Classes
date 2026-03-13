package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;
import com.rays.service.CourseServiceInt;

@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseDTO,CourseDAOInt> implements CourseServiceInt {


}
