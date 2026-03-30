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
import com.rays.dao.CollegeDAOInt;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;

/**
 * Implementation of StudentDAOInt interface. Provides database operations for
 * managing student information with dynamic search criteria and college name
 * population.
 * 
 * @author Aniket Rajput
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

	@Autowired
	private CollegeDAOInt collegeDao;

	/**
	 * Builds WHERE clause predicates for student search criteria. Supports
	 * searching by enrolment number, first name, college name, email, date of
	 * birth, and phone number.
	 * 
	 * @param dto     the StudentDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot   the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto != null) {

			if (!isEmptyString(dto.getEnrolNo())) {
				whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
			}

			if (!isEmptyString(dto.getFirstName())) {
				whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}

			if (!isEmptyString(dto.getCollegeName())) {
				whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
			}

			if (!isEmptyString(dto.getEmail())) {
				whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
			}

			if (isNotNull(dto.getDob())) {
				whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
			}

			if (!isEmptyString(dto.getPhoneNo())) {
				whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
			}

		}

		return whereCondition;
	}

	/**
	 * Populates the student DTO with college name based on college ID.
	 * 
	 * @param dto         the StudentDTO to populate
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void populate(StudentDTO dto, UserContext userContext) {
		CollegeDTO collegeDTO = collegeDao.findByPk(dto.getCollegeId(), userContext);
		if (collegeDTO != null) {
			dto.setCollegeName(collegeDTO.getName());
		}
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of StudentDTO
	 */
	@Override
	public Class<StudentDTO> getDTOClass() {
		return StudentDTO.class;
	}

}