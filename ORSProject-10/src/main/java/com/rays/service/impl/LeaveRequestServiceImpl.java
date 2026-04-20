package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.LeaveRequestDAOInt;
import com.rays.dto.LeaveRequestDTO;
import com.rays.service.LeaveRequestServiceInt;

@Service
@Transactional
public class LeaveRequestServiceImpl extends BaseServiceImpl<LeaveRequestDTO, LeaveRequestDAOInt> implements LeaveRequestServiceInt{

}
