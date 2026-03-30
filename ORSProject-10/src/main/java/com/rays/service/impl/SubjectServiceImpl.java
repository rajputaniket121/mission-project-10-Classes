package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.SubjectDAOInt;
import com.rays.dto.SubjectDTO;
import com.rays.service.SubjectServiceInt;

/**
 * Implementation of SubjectServiceInt interface. Provides business logic
 * operations for managing subject information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDTO, SubjectDAOInt> implements SubjectServiceInt {

}