package com.rays.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;
import com.rays.service.RoleServiceInt;

/**
 * Implementation of RoleServiceInt interface. Provides business logic
 * operations for managing role information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

}