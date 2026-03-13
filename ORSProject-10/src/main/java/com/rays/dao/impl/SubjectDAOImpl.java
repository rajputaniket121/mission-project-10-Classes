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

@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	@Autowired
	private CourseDAOInt courseDao;

	@Override
	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {
			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		return whereCondition;
	}

	@Override
	public void populate(SubjectDTO dto, UserContext userContext) {
		if (dto.getCourseId() != 0) {
			CourseDTO courseDTO = courseDao.findByPk(dto.getCourseId(), userContext);
			if (courseDTO != null) {
				dto.setCourseName(courseDTO.getName());
			}
		}
	}

	@Override
	public Class<SubjectDTO> getDTOClass() {
		return SubjectDTO.class;
	}

}
