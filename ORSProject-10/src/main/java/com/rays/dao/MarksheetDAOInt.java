package com.rays.dao;

import java.util.List;

import com.rays.common.BaseDAOInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

/**
 * Data Access Object interface for Marksheet entity.
 * Provides database operations for managing marksheet information,
 * including merit list retrieval.
 * 
 * @author Aniket Rajput
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {
	
	/**
	 * Retrieves the merit list of top performing students.
	 * 
	 * @param userContext the user context containing current user information
	 * @return list of marksheets sorted by total marks in descending order
	 */
	public List<MarksheetDTO> getMeritList(UserContext userContext);

}