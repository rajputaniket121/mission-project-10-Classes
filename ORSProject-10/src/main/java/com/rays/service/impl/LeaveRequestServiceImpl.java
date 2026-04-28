package com.rays.service.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.LeaveRequestDAOInt;
import com.rays.dto.LeaveRequestDTO;
import com.rays.service.LeaveRequestServiceInt;

@Service
@Transactional
public class LeaveRequestServiceImpl extends BaseServiceImpl<LeaveRequestDTO, LeaveRequestDAOInt> implements LeaveRequestServiceInt{
	@Autowired
	private DataSource dataSource;
	
//	@Transactional(readOnly = false)
//	@Override
//	public long add(LeaveRequestDTO dto, UserContext userContext) {
//	        System.out.println("\n---- SERVICE: CALLING DAO ----");
//	        Connection springConn = DataSourceUtils.getConnection(dataSource);
//	        System.out.println("🔗 SERVICE: Spring-managed Connection = " + 
//	            springConn + " | hashCode: " + System.identityHashCode(springConn));
//
//	        long pk = dao.add(dto, userContext);
//	        System.out.println(dao.findByPk(pk, userContext));
//
//	        System.out.println("\n---- SERVICE: AFTER DAO ----");
//	        if(true) {
//	        	throw new RuntimeException("Exception in add service");
//	        }
//	    return pk;
//	}

}
