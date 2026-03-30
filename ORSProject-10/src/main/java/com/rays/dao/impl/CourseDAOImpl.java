package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * Implementation of CourseDAOInt interface. Provides database operations for
 * managing course information with dynamic search criteria.
 * 
 * @author Aniket Rajput
 */
@Repository
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt {

	/**
	 * Builds WHERE clause predicates for course search criteria. Supports searching
	 * by name, description, and duration.
	 * 
	 * @param dto     the CourseDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot   the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto != null) {

			if (!isEmptyString(dto.getName())) {

				whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (!isEmptyString(dto.getDescription())) {

				whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
			}

			if (!isEmptyString(dto.getDuration())) {

				whereCondition.add(builder.like(qRoot.get("duration"), dto.getDuration() + "%"));
			}

		}

		return whereCondition;
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of CourseDTO
	 */
	@Override
	public Class<CourseDTO> getDTOClass() {
		return CourseDTO.class;
	}

}