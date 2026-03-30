package com.rays.dao;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOInt;
import com.rays.dto.RoleDTO;

/**
 * Data Access Object interface for Role entity.
 * Provides database operations for managing role information.
 * 
 * @author Aniket Rajput
 */
@Repository
public interface RoleDAOInt extends BaseDAOInt<RoleDTO>{

}