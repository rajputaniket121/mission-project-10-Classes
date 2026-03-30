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
import com.rays.dao.TimetableDAOInt;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimetableDTO;

/**
 * Implementation of TimetableDAOInt interface.
 * Provides database operations for managing timetable information
 * with dynamic search criteria and name population from related entities.
 * 
 * @author Aniket Rajput
 */
@Repository
public class TimetableDAOImpl extends BaseDAOImpl<TimetableDTO> implements TimetableDAOInt {
	
	@Autowired
	private SubjectDAOInt subjectDao;

	@Autowired
	private CourseDAOInt courseDao;

	/**
	 * Populates the timetable DTO with subject and course names
	 * based on their respective IDs.
	 * 
	 * @param dto the TimetableDTO to populate
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void populate(TimetableDTO dto, UserContext userContext) {

		SubjectDTO subjectDto = subjectDao.findByPk(dto.getSubjectId(), userContext);
		
		if (subjectDto != null) {
			dto.setSubjectName(subjectDto.getName());
		}

		CourseDTO courseDto = courseDao.findByPk(dto.getCourseId(), userContext);
		
		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}
		
		
	}

	/**
	 * Builds WHERE clause predicates for timetable search criteria.
	 * Supports searching by subject name and course name.
	 * 
	 * @param dto the TimetableDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(TimetableDTO dto, CriteriaBuilder builder, Root<TimetableDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if(dto!=null) {
			
			if (!isEmptyString(dto.getSubjectName())) {

				whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
			}
			if (!isEmptyString(dto.getCourseName())) {

				whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
			}
			
		}
		return whereCondition;
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of TimetableDTO
	 */
	@Override
	public Class<TimetableDTO> getDTOClass() {
		return TimetableDTO.class;
	}

}