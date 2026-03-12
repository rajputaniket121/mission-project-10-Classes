package com.rays.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	@Override
	protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<UserDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
