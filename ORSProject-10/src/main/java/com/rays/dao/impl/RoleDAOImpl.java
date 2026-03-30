package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

/**
 * Implementation of RoleDAOInt interface.
 * Provides database operations for managing role information
 * with dynamic search criteria.
 * 
 * @author Aniket Rajput
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

	/**
	 * Builds WHERE clause predicates for role search criteria.
	 * Supports searching by ID and name.
	 * 
	 * @param dto the RoleDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();
		System.out.println(dto);
		if(dto!=null) {
			
			if (!isZeroNumber(dto.getId())) {
				conditions.add(builder.equal(qRoot.get("id"), dto.getId()));
			}
			if(!isEmptyString(dto.getName())) {
				conditions.add(builder.like(qRoot.get("name"), dto.getName() +"%" ));
			}
		}
		
		return conditions;
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of RoleDTO
	 */
	@Override
	public Class<RoleDTO> getDTOClass() {
		return RoleDTO.class;
	}
	
}