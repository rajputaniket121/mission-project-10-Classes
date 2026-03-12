package com.rays.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

	@Override
	protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<CollegeDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
