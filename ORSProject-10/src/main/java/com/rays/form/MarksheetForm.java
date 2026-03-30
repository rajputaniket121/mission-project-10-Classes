package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

/**
 * Form for Marksheet entity.
 * Handles validation and DTO conversion for student marks including
 * Physics, Chemistry, and Mathematics scores.
 * 
 * @author Aniket Rajput
 */
public class MarksheetForm extends BaseForm<MarksheetDTO> {

	@NotEmpty(message = "Roll No is required")
	protected String rollNo = null;

	@NotNull(message = "Student Name is required")
	@Min(1)
	protected Long studentId;

	protected String name = null;

	@NotNull(message = "Physics is required")
	@Max(99)
	@Min(0)
	protected Integer physics;

	@NotNull(message = "Chemistry is required")
	@Max(99)
	@Min(0)
	protected Integer chemistry;

	@NotNull(message = "Maths is required")
	@Max(99)
	@Min(0)
	protected Integer maths;

	/**
	 * Gets the roll number.
	 * 
	 * @return the roll number
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets the roll number.
	 * 
	 * @param rollNo the roll number to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Gets the student ID.
	 * 
	 * @return the student ID
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student ID.
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
	 * Converts the form data to a MarksheetDTO.
	 * 
	 * @return the populated MarksheetDTO
	 */
	@Override
	public MarksheetDTO getDto() {

		MarksheetDTO dto = initDTO(new MarksheetDTO());
		dto.setRollNo(rollNo);
		dto.setName(name);
		dto.setStudentId(studentId);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);
		dto.setMaths(maths);

		return dto;
	}

	@Override
	public String toString() {
		return "MarksheetForm [rollNo=" + rollNo + ", studentId=" + studentId + ", name=" + name + ", physics="
				+ physics + ", chemistry=" + chemistry + ", maths=" + maths + "]";
	}
}