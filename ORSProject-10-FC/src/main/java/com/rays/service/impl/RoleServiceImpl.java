package com.rays.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;
import com.rays.service.RoleServiceInt;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO,RoleDAOInt> implements RoleServiceInt{

}
