package com.rays.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.rays.common.UserContext;
import com.rays.common.impl.BaseServiceImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;
import com.rays.service.CollegeServiceInt;

/**
 * Implementation of CollegeServiceInt interface. Provides business logic
 * operations for managing college information.
 * 
 * @author Aniket Rajput
 */
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {
	
	@Override
	public long add(CollegeDTO dto, UserContext userContext) {
		
		long pk = dao.add(dto, userContext);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		if(true) {
			throw new RuntimeException("exception in serivice");
		}
		return pk;
	}

}