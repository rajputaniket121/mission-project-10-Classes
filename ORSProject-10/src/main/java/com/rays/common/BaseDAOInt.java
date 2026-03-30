package com.rays.common;

import java.util.List;

/**
 * Base Data Access Object interface providing common database operations.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/**
	 * Adds a new entity to the database.
	 * 
	 * @param dto         the DTO to be added
	 * @param userContext the user context containing current user information
	 * @return the generated ID of the added entity
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing entity in the database.
	 * 
	 * @param dto         the DTO with updated values
	 * @param userContext the user context containing current user information
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Deletes an entity from the database.
	 * 
	 * @param dto         the DTO to be deleted
	 * @param userContext the user context containing current user information
	 */
	public void delete(T dto, UserContext userContext);

	/**
	 * Finds an entity by its primary key ID.
	 * 
	 * @param id          the primary key ID to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	public T findByPk(long id, UserContext userContext);

	/**
	 * Finds an entity by a unique key attribute.
	 * 
	 * @param attribute   the attribute name to search by
	 * @param value       the attribute value to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	public T findByUniqueKey(String attribute, Object value, UserContext userContext);

	/**
	 * Searches for entities matching the given DTO criteria.
	 * 
	 * @param dto         the DTO containing search criteria
	 * @param userContext the user context containing current user information
	 * @return list of DTOs matching the search criteria
	 */
	public List<T> search(T dto, UserContext userContext);

	/**
	 * Searches for entities matching the given DTO criteria with pagination.
	 * 
	 * @param dto         the DTO containing search criteria
	 * @param pageNo      the page number to retrieve (zero-based)
	 * @param pageSize    the number of records per page
	 * @param userContext the user context containing current user information
	 * @return list of DTOs matching the search criteria for the specified page
	 */
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext);

}