package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_LEAVE_REQUEST")
public class LeaveRequestDTO extends BaseDTO{
	
	@Column(name = "EMPLOYEENAME",length = 50)
	private String employeeName;
	
	@Column(name = "LEAVETYPE",length = 50)
	private String leaveType;
	
	
	@Column(name = "LEAVEDATE")
	private Date leaveDate;
	
	@Column(name = "REASON",length = 50)
	private String reason;
	

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the leaveType
	 */
	public String getLeaveType() {
		return leaveType;
	}

	/**
	 * @param leaveType the leaveType to set
	 */
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * @return the leaveDate
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * @param leaveDate the leaveDate to set
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String getValue() {
		return leaveType;
	}

	@Override
	public String getUniqueKey() {
		return "employeeName";
	}

	@Override
	public String getUniqueValue() {
		return employeeName;
	}

	@Override
	public String getLabel() {
		return "Leave Request";
	}

	@Override
	public String getTableName() {
		return "Leave Request";
	}

	@Override
	public String toString() {
		return "LeaveRequest [employeeName=" + employeeName + ", leaveType=" + leaveType + ", leaveDate=" + leaveDate
				+ ", reason=" + reason + "]";
	}
	

}
