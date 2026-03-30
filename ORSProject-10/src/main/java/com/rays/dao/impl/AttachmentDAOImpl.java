package com.rays.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.AttachmentDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * Implementation of AttachmentDAOInt interface.
 * Provides database operations for managing file attachments.
 * 
 * @author Aniket Rajput
 */
@Repository
public class AttachmentDAOImpl extends BaseDAOImpl<AttachmentDTO> implements AttachmentDAOInt {

	/**
	 * Builds WHERE clause predicates for attachment search criteria.
	 * 
	 * @param dto the AttachmentDTO containing search criteria
	 * @param builder the CriteriaBuilder instance
	 * @param qRoot the Root instance for the entity
	 * @return list of Predicates for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(AttachmentDTO dto, CriteriaBuilder builder, Root<AttachmentDTO> qRoot) {
		return null;
	}

	/**
	 * Gets the DTO class for this DAO implementation.
	 * 
	 * @return the Class object of AttachmentDTO
	 */
	@Override
	public Class<AttachmentDTO> getDTOClass() {
		return AttachmentDTO.class;
	}

}