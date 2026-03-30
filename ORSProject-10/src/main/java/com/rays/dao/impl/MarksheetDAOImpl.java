package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

/**
 * Implementation of MarksheetDAOInt interface. Provides database operations for
 * managing marksheet information, including merit list retrieval and dynamic
 * search.
 * 
 * @author Aniket Rajput
 */
@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

	@Autowired
	private StudentDAOInt studentDao;

	/**
	 * Builds WHERE clause predicates for marksheet search criteria. Supports
	 * searching by name, roll number, and student ID.
	 * 
	 * @param dto     the MarksheetDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot   the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(MarksheetDTO dto, CriteriaBuilder builder, Root<MarksheetDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (dto != null) {

			if (!isEmptyString(dto.getName())) {

				whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (!isEmptyString(dto.getRollNo())) {

				whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo() + "%"));
			}

			if (!isZeroNumber(dto.getStudentId())) {

				whereCondition.add(builder.equal(qRoot.get("studentId"), dto.getStudentId()));
			}

		}

		return whereCondition;
	}

	/**
	 * Populates the marksheet DTO with student name based on student ID.
	 * 
	 * @param dto         the MarksheetDTO to populate
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void populate(MarksheetDTO dto, UserContext userContext) {
		if (dto.getStudentId() != null) {
			StudentDTO studentDTO = studentDao.findByPk(dto.getStudentId(), userContext);
			if (studentDTO != null) {
				dto.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
			}
		}
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of MarksheetDTO
	 */
	@Override
	public Class<MarksheetDTO> getDTOClass() {
		return MarksheetDTO.class;
	}

	/**
	 * Retrieves the merit list of top 10 students based on total marks. Results are
	 * sorted by sum of physics, chemistry, and maths in descending order.
	 * 
	 * @param userContext the user context containing current user information
	 * @return list of top 10 marksheets ordered by total marks
	 */
	@Override
	public List<MarksheetDTO> getMeritList(UserContext userContext) {
		TypedQuery<MarksheetDTO> typedQuery = entityManager
				.createQuery("from MarksheetDTO order by (physics+chemistry+maths) desc", getDTOClass());
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(10);
		List<MarksheetDTO> meritlist = typedQuery.getResultList();
		return meritlist;
	}

}