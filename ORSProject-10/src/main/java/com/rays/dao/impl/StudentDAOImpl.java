package com.rays.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;

public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

	@Override
	protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<StudentDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
