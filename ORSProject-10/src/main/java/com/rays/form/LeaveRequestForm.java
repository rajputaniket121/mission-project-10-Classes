package com.rays.form;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.LeaveRequestDTO;

public class LeaveRequestForm extends BaseForm<LeaveRequestDTO> {
	
	@NotEmpty(message = "Employee Name Is Required")
	private String employeeName;
	
	@NotEmpty(message = "Leave Type Is Required")
	private String leaveType;
	
	
	@NotNull(message = "leave Date Is Required")
	private Date leaveDate;
	
	@NotEmpty(message = "Reason Is Required")
	private String reason;
	
	@Override
	public LeaveRequestDTO getDto() {
		LeaveRequestDTO dto = initDTO(new LeaveRequestDTO());
		
		dto.setEmployeeName(employeeName);
		dto.setLeaveType(leaveType);
		dto.setLeaveDate(leaveDate);
		dto.setReason(reason);
		
		return dto;
	}

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
	public String toString() {
		return "LeaveRequestForm [employeeName=" + employeeName + ", leaveType=" + leaveType + ", leaveDate="
				+ leaveDate + ", reason=" + reason + "]";
	}

}
