package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;
import com.rays.service.CollegeServiceInt;

/**
 * Implementation of CollegeServiceInt interface. Provides business logic
 * operations for managing college information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {

}