package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;
import com.rays.service.StudentServiceInt;

/**
 * Implementation of StudentServiceInt interface.
 * Provides business logic operations for managing student information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<StudentDTO,StudentDAOInt> implements StudentServiceInt{

}