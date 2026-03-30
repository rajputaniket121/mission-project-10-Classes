package com.rays.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;
import com.rays.service.MarksheetServiceInt;

/**
 * Implementation of MarksheetServiceInt interface.
 * Provides business logic operations for managing marksheet information,
 * including merit list retrieval and roll number search.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO,MarksheetDAOInt> implements MarksheetServiceInt {
	
	/**
	 * Retrieves the merit list of top performing students.
	 * 
	 * @param userContext the user context containing current user information
	 * @return list of top 10 marksheets ordered by total marks
	 */
	@Transactional(readOnly = true)
	public List<MarksheetDTO> getMeritList(UserContext userContext){
		return dao.getMeritList(userContext);
	}
	
	/**
	 * Finds a marksheet by roll number.
	 * 
	 * @param rollNo the roll number to search for
	 * @param context the user context
	 * @return the marksheet DTO if found, null otherwise
	 */
	@Override
	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return dao.findByUniqueKey("rollNo", rollNo, context);
	}

}