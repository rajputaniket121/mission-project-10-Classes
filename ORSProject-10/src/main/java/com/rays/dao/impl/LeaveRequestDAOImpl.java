package com.rays.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.impl.BaseDAOImpl;
import com.rays.dao.LeaveRequestDAOInt;
import com.rays.dto.LeaveRequestDTO;

@Repository
public class LeaveRequestDAOImpl extends BaseDAOImpl<LeaveRequestDTO> implements LeaveRequestDAOInt {

	@Override
	protected List<Predicate> getWhereClause(LeaveRequestDTO dto, CriteriaBuilder builder,
			Root<LeaveRequestDTO> qRoot) {
		List<Predicate> conditions = new ArrayList<Predicate>();
		
		if(dto!=null) {
			if(!isEmptyString(dto.getEmployeeName())) {
				conditions.add(builder.like(qRoot.get("employeeName"), dto.getEmployeeName() +"%"));
			}
			if(!isEmptyString(dto.getLeaveType())) {
				conditions.add(builder.like(qRoot.get("leaveType"), dto.getLeaveType() +"%"));
			}
			if(isNotNull(dto.getLeaveDate())) {
				conditions.add(builder.equal(qRoot.get("leaveDate"), dto.getLeaveDate()));
			}
			if(!isEmptyString(dto.getReason())) {
				conditions.add(builder.like(qRoot.get("reason"), dto.getReason()));
			}
		}
		return conditions;
	}

	@Override
	public Class<LeaveRequestDTO> getDTOClass() {
		return LeaveRequestDTO.class;
	}

}
