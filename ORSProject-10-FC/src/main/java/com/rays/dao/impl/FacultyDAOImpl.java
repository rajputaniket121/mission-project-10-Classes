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
import com.rays.dao.CourseDAOInt;
import com.rays.dao.FacultyDAOInt;
import com.rays.dao.SubjectDAOInt;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	@Autowired
	private CollegeDAOInt collegeDao;

	@Autowired
	private CourseDAOInt courseDao;

	@Autowired
	private SubjectDAOInt subjectDao;

	@Override
	public void populate(FacultyDTO dto, UserContext userContext) {

		if (dto.getCollegeId() > 0) {
			CollegeDTO collegeDto = collegeDao.findByPk(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDto.getName());
		}
		if (dto.getCourseId() > 0) {
			CourseDTO courseDto = courseDao.findByPk(dto.getCourseId(), userContext);
			dto.setCourseName(courseDto.getName());
		}
		if (dto.getSubjectId() > 0) {
			SubjectDTO subjectDto = subjectDao.findByPk(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDto.getName());
		}
	}

	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if(dto!=null) {
			
			if (!isEmptyString(dto.getFirstName())) {

				whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}

			if (!isEmptyString(dto.getEmail())) {

				whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
			}

			if (!isEmptyString(dto.getCollegeName())) {

				whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
			}

			if (!isEmptyString(dto.getCourseName())) {

				whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
			}

			if (!isEmptyString(dto.getSubjectName())) {

				whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
			}
			
		}

		return whereCondition;
	}

	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

}