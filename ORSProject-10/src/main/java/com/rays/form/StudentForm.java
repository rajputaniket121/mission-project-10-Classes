package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

/**
 * Form for Student entity.
 * Handles validation and DTO conversion for student data including
 * enrollment number, personal details, and associated college.
 * 
 * @author Aniket Rajput
 */
public class StudentForm extends BaseForm<StudentDTO>{
	
	@NotEmpty(message = "Enroll No is required")
	private String enrolNo;

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	@NotEmpty(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	@NotEmpty(message = "Email ID is required")
	@Email
	private String email;

	@NotNull(message = "College Name is required")
	@Min(1)
	private Long collegeId;

	private String collegeName;

	/**
	 * Gets the enrollment number.
	 * 
	 * @return the enrollment number
	 */
	public String getEnrolNo() {
		return enrolNo;
	}

	/**
	 * Sets the enrollment number.
	 * 
	 * @param enrolNo the enrollment number to set
	 */
	public void setEnrolNo(String enrolNo) {
		this.enrolNo = enrolNo;
	}

	/**
	 * Gets the student's first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the student's first name.
	 * 
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the student's last name.
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the student's date of birth.
	 * 
	 * @return the date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the student's date of birth.
	 * 
	 * @param dob the date of birth to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the student's phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the student's phone number.
	 * 
	 * @param phoneNo the phone number to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the student's email address.
	 * 
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the student's email address.
	 * 
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the college ID where student is enrolled.
	 * 
	 * @return the college ID
	 */
	public Long getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets the college ID where student is enrolled.
	 * 
	 * @param collegeId the college ID to set
	 */
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Gets the college name where student is enrolled.
	 * 
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets the college name where student is enrolled.
	 * 
	 * @param collegeName the college name to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Converts the form data to a StudentDTO.
	 * 
	 * @return the populated StudentDTO
	 */
	@Override
	public StudentDTO getDto() {

		StudentDTO dto = initDTO(new StudentDTO());

		dto.setEnrolNo(enrolNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(dob);
		dto.setPhoneNo(phoneNo);
		dto.setEmail(email);
		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);

		return dto;
	}

	@Override
	public String toString() {
		return "StudentForm [enrolNo=" + enrolNo + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", phoneNo=" + phoneNo + ", email=" + email + ", collegeId=" + collegeId + ", collegeName="
				+ collegeName + "]";
	}
}