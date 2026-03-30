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
import com.rays.service.AttachmentServiceInt;

/**
 * Implementation of UserDAOInt interface. Provides database operations for
 * managing user information with dynamic search criteria, role name population,
 * and cascade delete for associated profile pictures.
 * 
 * @author Aniket Rajput
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	@Autowired
	private RoleDAOInt roleDao;

	@Autowired
	private AttachmentServiceInt attachmentServiceInt;

	/**
	 * Builds WHERE clause predicates for user search criteria. Supports searching
	 * by first name, login ID, role ID, date of birth, and status.
	 * 
	 * @param dto     the UserDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot   the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
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

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of UserDTO
	 */
	@Override
	public Class<UserDTO> getDTOClass() {
		return UserDTO.class;
	}

	/**
	 * Populates the user DTO with role name and preserves existing last login and
	 * image ID information.
	 * 
	 * @param dto         the UserDTO to populate
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void populate(UserDTO dto, UserContext userContext) {
		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDTO roleDto = roleDao.findByPk(dto.getRoleId(), userContext);
			dto.setRoleName(roleDto.getName());
		}
		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPk(dto.getId(), userContext);
			dto.setLastLogin(userData.getLastLogin());
		}
		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPk(dto.getId(), userContext);
			dto.setImageId(userData.getImageId());
		}
	}

	/**
	 * Deletes a user and also deletes their associated profile picture to maintain
	 * data integrity.
	 * 
	 * @param dto         the UserDTO to delete
	 * @param userContext the user context containing current user information
	 */
	@Override
	public void delete(UserDTO dto, UserContext userContext) {
		if (dto.getImageId() != null && dto.getImageId() > 0) {
			attachmentServiceInt.delete(dto.getImageId(), userContext);
		}
		super.delete(dto, userContext);
	}

}