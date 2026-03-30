package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dao.SubjectDAOInt;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;

/**
 * Implementation of SubjectDAOInt interface.
 * Provides database operations for managing subject information
 * with dynamic search criteria and course name population.
 * 
 * @author Aniket Rajput
 */
@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	@Autowired
	private CourseDAOInt courseDao;

	/**
	 * Builds WHERE clause predicates for subject search criteria.
	 * Supports searching by name and course name.
	 * 
	 * @param dto the SubjectDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if(dto!=null) {
			
			if (!isEmptyString(dto.getName())) {
				whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (!isEmptyString(dto.getCourseName())) {
				whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
			}
			
		}

		return whereCondition;
	}

	/**
	 * Populates the subject DTO with course name based on course ID.
	 * 
	 * @param dto the SubjectDTO to populate
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void populate(SubjectDTO dto, UserContext userContext) {
		if (dto.getCourseId() != 0) {
			CourseDTO courseDTO = courseDao.findByPk(dto.getCourseId(), userContext);
			if (courseDTO != null) {
				dto.setCourseName(courseDTO.getName());
			}
		}
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of SubjectDTO
	 */
	@Override
	public Class<SubjectDTO> getDTOClass() {
		return SubjectDTO.class;
	}

}