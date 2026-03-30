package com.rays.common.impl;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.common.BaseDAOInt;
import com.rays.common.BaseDTO;
import com.rays.common.UserContext;

/**
 * Base Data Access Object implementation providing common database operations
 * using JPA Criteria API.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Builds the WHERE clause predicates for search criteria.
	 * 
	 * @param dto     the DTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot   the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of the DTO
	 */
	public abstract Class<T> getDTOClass();

	/**
	 * Populates additional fields in the DTO before persistence. Override this
	 * method to set custom values.
	 * 
	 * @param dto         the DTO to populate
	 * @param userContext the user context
	 */
	public void populate(T dto, UserContext userContext) {
	}

	/**
	 * Adds a new entity to the database.
	 * 
	 * @param dto         the DTO to be added
	 * @param userContext the user context containing current user information
	 * @return the generated ID of the added entity
	 */
	@Override
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDateTime(new Timestamp(new Date().getTime()));

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	/**
	 * Updates an existing entity in the database.
	 * 
	 * @param dto         the DTO with updated values
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	/**
	 * Deletes an entity from the database.
	 * 
	 * @param dto         the DTO to be deleted
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void delete(T dto, UserContext userContext) {

		entityManager.remove(dto);

	}

	/**
	 * Finds an entity by its primary key ID.
	 * 
	 * @param id          the primary key ID to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	@Override
	public T findByPk(long id, UserContext userContext) {

		T dto = entityManager.find(getDTOClass(), id);

		return dto;
	}

	/**
	 * Finds an entity by a unique key attribute.
	 * 
	 * @param attribute   the attribute name to search by
	 * @param value       the attribute value to search for
	 * @param userContext the user context containing current user information
	 * @return the found DTO, or null if not found
	 */
	@Override
	public T findByUniqueKey(String attribute, Object value, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(dtoClass);

		Root<T> qRoot = criteriaQuery.from(dtoClass);

		Predicate condition = criteriaBuilder.equal(qRoot.get(attribute), value);

		criteriaQuery.where(condition);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		List<T> result = typedQuery.getResultList();

		T dto = null;

		if (result.size() == 1) {
			dto = result.get(0);
		}

		return dto;
	}

	/**
	 * Creates a TypedQuery for searching based on the DTO criteria.
	 * 
	 * @param dto         the DTO containing search criteria
	 * @param userContext the user context
	 * @return TypedQuery for executing the search
	 */
	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDTOClass());

		Root<T> qRoot = criteriaQuery.from(getDTOClass());

		criteriaQuery.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, criteriaBuilder, qRoot);

		for (Predicate condition : whereClause) {
			criteriaQuery.where(condition);
		}

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		return typedQuery;
	}

	/**
	 * Searches for entities matching the given DTO criteria.
	 * 
	 * @param dto         the DTO containing search criteria
	 * @param userContext the user context containing current user information
	 * @return list of all DTOs matching the search criteria
	 */
	@Override
	public List<T> search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Searches for entities matching the given DTO criteria with pagination.
	 * 
	 * @param dto         the DTO containing search criteria
	 * @param pageNo      the page number to retrieve (zero-based)
	 * @param pageSize    the number of records per page
	 * @param userContext the user context containing current user information
	 * @return list of DTOs matching the search criteria for the specified page
	 */
	@Override
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {

		TypedQuery<T> typedQuery = createCriteria(dto, userContext);

		if (pageSize > 0) {
			typedQuery.setFirstResult(pageNo * pageSize);
			typedQuery.setMaxResults(pageSize);
		}

		List<T> list = typedQuery.getResultList();

		return list;
	}

	/**
	 * Checks if a string is null or empty.
	 * 
	 * @param val the string to check
	 * @return true if null or empty, false otherwise
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Checks if a Double value is null or zero.
	 * 
	 * @param val the Double to check
	 * @return true if null or zero, false otherwise
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if a Long value is null or zero.
	 * 
	 * @param val the Long to check
	 * @return true if null or zero, false otherwise
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if an Integer value is null or zero.
	 * 
	 * @param val the Integer to check
	 * @return true if null or zero, false otherwise
	 */
	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	/**
	 * Checks if an object is not null.
	 * 
	 * @param val the object to check
	 * @return true if not null, false otherwise
	 */
	protected boolean isNotNull(Object val) {
		return val != null;
	}

}