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
import com.rays.dao.RoleDAOInt;
import com.rays.dao.UserDAOInt;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	@Autowired
	private RoleDAOInt roleDao;

	@Override
	protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();

		if (dto != null) {
			if (!isEmptyString(dto.getFirstName())) {
				conditions.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}
			if (!isEmptyString(dto.getLoginId())) {
				conditions.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
			}
			if (!isZeroNumber(dto.getRoleId())) {
				conditions.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
			}
			if (isNotNull(dto.getDob())) {
				conditions.add(builder.equal(qRoot.get("dob"), dto.getDob()));
			}
			if (!isEmptyString(dto.getStatus())) {
				conditions.add(builder.equal(qRoot.get("status"), dto.getStatus()));
			}
		}

		return conditions;
	}

	@Override
	public Class<UserDTO> getDTOClass() {
		return UserDTO.class;
	}

	@Override
	public void populate(UserDTO dto, UserContext userContext) {
		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDTO roleDto = roleDao.findByPk(dto.getRoleId(), userContext);
			dto.setRoleName(roleDto.getName());
		}
		if(dto.getId()>0) {
			UserDTO userData = findByPk(dto.getId(), userContext);
			dto.setLastLogin(userData.getLastLogin());
		}
	}

}
