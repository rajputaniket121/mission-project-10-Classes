package com.rays.service;

import java.util.List;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

/**
 * Service interface for Marksheet entity.
 * Provides business logic operations for managing marksheet information,
 * including merit list retrieval and roll number search.
 * 
 * @author Aniket Rajput
 */
public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {
	
	/**
	 * Retrieves the merit list of top performing students.
	 * 
	 * @param userContext the user context containing current user information
	 * @return list of marksheets sorted by total marks
	 */
	List<MarksheetDTO> getMeritList(UserContext userContext);

	/**
	 * Finds a marksheet by roll number.
	 * 
	 * @param rollNo the roll number to search for
	 * @param context the user context
	 * @return the marksheet DTO if found, null otherwise
	 */
	MarksheetDTO findByRollNo(String rollNo, UserContext context);

}