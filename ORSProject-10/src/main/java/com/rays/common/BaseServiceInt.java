package com.rays.common;

import java.util.List;

/**
 * Base Service Interface providing common business logic operations.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 */
public interface BaseServiceInt<T extends BaseDTO> {
	
	/**
	 * Adds a new entity to the system.
	 * 
	 * @param dto the DTO to be added
	 * @param userContext the user context containing current user information
	 * @return the generated ID of the added entity
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing entity in the system.
	 * 
	 * @param dto the DTO with updated values
	 * @param userContext the user context containing current user information
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Saves an entity (adds if ID is null, updates if ID exists).
	 * 
	 * @param dto the DTO to be saved
	 * @param userContext the user context containing current user information
	 * @return the ID of the saved entity
	 */
	public long save(T dto, UserContext userContext);

	/**
	 * Deletes an entity by its ID.
	 * 
	 * @param id the ID of the entity to delete
	 * @param userContext the user context containing current user information
	 * @return the deleted DTO
	 */
	public T delete(long id, UserContext userContext);

	/**
	 * Finds an entity by its ID.
	 * 
	 * @param id the ID to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	public T findById(long id, UserContext userContext);

	/**
	 * Finds an entity by a unique key attribute and value.
	 * 
	 * @param attribute the attribute name to search by
	 * @param val the attribute value to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	public T findByUniqueKey(String attribute, String val, UserContext userContext);

	/**
	 * Searches for entities matching the given DTO criteria with pagination.
	 * 
	 * @param dto the DTO containing search criteria
	 * @param pageNo the page number to retrieve (zero-based)
	 * @param pageSize the number of records per page
	 * @param userContext the user context containing current user information
	 * @return list of DTOs matching the search criteria for the specified page
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches for entities matching the given DTO criteria.
	 * 
	 * @param dto the DTO containing search criteria
	 * @param userContext the user context containing current user information
	 * @return list of all DTOs matching the search criteria
	 */
	public List search(T dto, UserContext userContext);

}