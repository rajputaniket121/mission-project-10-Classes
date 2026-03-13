package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_MARKSHEET")
public class MarksheetDTO extends BaseDTO {

	@Column(name = "ROLL_NO", length = 20)
	protected String rollNo = null;

	@Column(name = "STUDENT_ID")
	protected Long studentId;

	@Column(name = "NAME", length = 50)
	protected String name = null;

	@Column(name = "PHYSICS")
	protected Integer physics;

	@Column(name = "CHEMISTRY")
	protected Integer chemistry;

	@Column(name = "MATHS")
	protected Integer maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	
	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	@Override
	public String getLabel() {
		return "Roll No";
	}
	
	@Override
	public String getTableName() {
		return "Marksheet";
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String toString() {
		return "MarksheetDTO [rollNo=" + rollNo + ", studentId=" + studentId + ", name=" + name + ", physics=" + physics
				+ ", chemistry=" + chemistry + ", maths=" + maths + "]";
	}
	
	
}