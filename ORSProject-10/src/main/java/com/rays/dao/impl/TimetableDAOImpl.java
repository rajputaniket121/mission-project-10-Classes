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

@Repository
public class TimetableDAOImpl extends BaseDAOImpl<TimetableDTO> implements TimetableDAOInt {
	
	@Autowired
	private SubjectDAOInt subjectDao;

	@Autowired
	private CourseDAOInt courseDao;

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

	@Override
	protected List<Predicate> getWhereClause(TimetableDTO dto, CriteriaBuilder builder, Root<TimetableDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getSubjectName())) {

			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}
		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}
		return whereCondition;
	}

	@Override
	public Class<TimetableDTO> getDTOClass() {
		return TimetableDTO.class;
	}

}
