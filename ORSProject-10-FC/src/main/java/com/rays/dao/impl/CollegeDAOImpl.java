package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

@Repository
public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

	@Override
	protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		System.out.println(dto);

		if(dto!=null) {
			if (!isEmptyString(dto.getName())) {
				conditions.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			}

			if (!isEmptyString(dto.getCity())) {
				conditions.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
			}

			if (!isEmptyString(dto.getState())) {
				conditions.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
			}

			if (!isEmptyString(dto.getAddress())) {
				conditions.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
			}

			if (!isEmptyString(dto.getPhoneNo())) {
				conditions.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
			}
		}

		return conditions;
	}

	@Override
	public Class<CollegeDTO> getDTOClass() {
		return CollegeDTO.class;
	}

}
