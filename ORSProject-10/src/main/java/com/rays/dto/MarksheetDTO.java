package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Marksheet entity. Contains student marks for
 * Physics, Chemistry, and Mathematics subjects, along with roll number and
 * student information.
 * 
 * @author Aniket Rajput
 */
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

	/**
	 * Gets the roll number of the student.
	 * 
	 * @return the roll number
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets the roll number of the student.
	 * 
	 * @param rollNo the roll number to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Gets the student ID associated with this marksheet.
	 * 
	 * @return the student ID
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student ID associated with this marksheet.
	 * 
	 * @param studentId the student ID to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the student name.
	 * 
	 * @return the student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the student name.
	 * 
	 * @param name the student name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Physics marks.
	 * 
	 * @return the Physics marks
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * Sets the Physics marks.
	 * 
	 * @param physics the Physics marks to set
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * Gets the Chemistry marks.
	 * 
	 * @return the Chemistry marks
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * Sets the Chemistry marks.
	 * 
	 * @param chemistry the Chemistry marks to set
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * Gets the Mathematics marks.
	 * 
	 * @return the Mathematics marks
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * Sets the Mathematics marks.
	 * 
	 * @param maths the Mathematics marks to set
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "rollNo" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the roll number
	 */
	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Roll No" as the label
	 */
	@Override
	public String getLabel() {
		return "Roll No";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Marksheet" as the table name
	 */
	@Override
	public String getTableName() {
		return "Marksheet";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return null as marksheet is not typically used in dropdowns
	 */
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