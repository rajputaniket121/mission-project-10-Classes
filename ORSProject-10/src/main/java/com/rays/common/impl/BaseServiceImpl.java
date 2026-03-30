package com.rays.common.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseDAOInt;
import com.rays.common.BaseDTO;
import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;

/**
 * Base Service implementation providing common business logic operations
 * with transaction management.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 * @param <D> DAO type extending BaseDAOInt
 */
@Transactional
public class BaseServiceImpl<T extends BaseDTO,D extends BaseDAOInt<T>> implements BaseServiceInt<T> {
	
	@Autowired
	protected D dao;

	/**
	 * Adds a new entity to the system.
	 * 
	 * @param dto the DTO to be added
	 * @param userContext the user context containing current user information
	 * @return the generated ID of the added entity
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto, UserContext userContext) {
		 long id = dao.add(dto, userContext);
		return id;
	}

	/**
	 * Updates an existing entity in the system.
	 * Preserves createdBy and createdDateTime from the existing record.
	 * 
	 * @param dto the DTO with updated values
	 * @param userContext the user context containing current user information
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext) {
		T existDto = findById(dto.getId(), userContext);
		if(existDto!=null) {
			dto.setCreatedBy(existDto.getCreatedBy());
			dto.setCreatedDateTime(existDto.getCreatedDateTime());
		}
		dao.update(dto, userContext);
	}

	/**
	 * Saves an entity (adds if ID is null, updates if ID exists).
	 * 
	 * @param dto the DTO to be saved
	 * @param userContext the user context containing current user information
	 * @return the ID of the saved entity
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext) {
		Long id = dto.getId();
		if(id != null && id > 0) {
			update(dto, userContext);
		}else {
			id = add(dto, userContext);
		}
		return id;
	}

	/**
	 * Deletes an entity by its ID.
	 * 
	 * @param id the ID of the entity to delete
	 * @param userContext the user context containing current user information
	 * @return the deleted DTO
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) {
		T dto = findById(id, userContext);
		dao.delete(dto, userContext);
		return dto;
	}

	/**
	 * Finds an entity by its ID.
	 * 
	 * @param id the ID to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	@Override
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto =  dao.findByPk(id, userContext);
		return dto;
	}

	/**
	 * Finds an entity by a unique key attribute and value.
	 * 
	 * @param attribute the attribute name to search by
	 * @param val the attribute value to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	@Override
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val, UserContext userContext) {
		T dto =  dao.findByUniqueKey(attribute, val, userContext);
		return dto;
	}

	/**
	 * Searches for entities matching the given DTO criteria with pagination.
	 * 
	 * @param dto the DTO containing search criteria
	 * @param pageNo the page number to retrieve (zero-based)
	 * @param pageSize the number of records per page
	 * @param userContext the user context containing current user information
	 * @return list of DTOs matching the search criteria for the specified page
	 */
	@Override
	@Transactional(readOnly = true)
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
		List<T> list =  dao.search(dto, pageNo, pageSize, userContext);
		return list;
	}

	/**
	 * Searches for all entities matching the given DTO criteria.
	 * 
	 * @param dto the DTO containing search criteria
	 * @param userContext the user context containing current user information
	 * @return list of all DTOs matching the search criteria
	 */
	@Override
	@Transactional(readOnly = true)
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

}