package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		if(dto!=null) {
			if (!isZeroNumber(dto.getId())) {
				conditions.add(builder.equal(qRoot.get("id"), dto.getId()));
			}
			if(isEmptyString(dto.getName())) {
				conditions.add(builder.like(qRoot.get("name"), dto.getName() +"%" ));
			}
		}
		
		return conditions;
	}

	@Override
	public Class<RoleDTO> getDTOClass() {
		return RoleDTO.class;
	}
	
	

}
