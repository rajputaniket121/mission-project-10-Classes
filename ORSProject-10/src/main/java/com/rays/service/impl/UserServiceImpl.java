package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO,UserDAOInt> implements UserServiceInt {

}
