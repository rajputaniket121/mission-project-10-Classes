package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.FacultyDAOInt;
import com.rays.dto.FacultyDTO;
import com.rays.service.FacultyServiceInt;

/**
 * Implementation of FacultyServiceInt interface.
 * Provides business logic operations for managing faculty information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class FacultyServiceImpl extends BaseServiceImpl<FacultyDTO,FacultyDAOInt> implements FacultyServiceInt {


}