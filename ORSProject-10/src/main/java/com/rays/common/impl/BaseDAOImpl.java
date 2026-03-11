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

public class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot) {
		return null;
	}

	public Class<T> getDTOClass() {
		return null;
	}

	public void populate(T dto, UserContext userContext) {
	}

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

	@Override
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDateTime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	@Override
	public void delete(T dto, UserContext userContext) {

		entityManager.remove(dto);
		
	}

	@Override
	public T findByPk(long id, UserContext userContext) {

		T dto = entityManager.find(getDTOClass(), id);

		return dto;
	}

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

		if (result.size() == 0) {
			dto = result.get(0);
		}

		return dto;
	}

	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDTOClass());
		
		Root<T> qRoot = criteriaQuery.from(getDTOClass());
		
		criteriaQuery.select(qRoot);
		
		List<Predicate> whereClause = getWhereClause(dto, criteriaBuilder, qRoot);
		
		for(Predicate condition : whereClause) {
			criteriaQuery.where(condition);
		}
		
		TypedQuery<T> typedQuery =  entityManager.createQuery(criteriaQuery);
		
		return typedQuery;
	}

	@Override
	public List<T> search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	@Override
	public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
		
		TypedQuery<T> typedQuery =  createCriteria(dto, userContext);
		
		if(pageSize>0) {
			typedQuery.setFirstResult(pageNo * pageSize);
			typedQuery.setMaxResults(pageSize);
		}
		
		List<T> list = typedQuery.getResultList();

		return list;
	}
	
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	protected boolean isNotNull(Object val) {
		return val != null;
	}

}
