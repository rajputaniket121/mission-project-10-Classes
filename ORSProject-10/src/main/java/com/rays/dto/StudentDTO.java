package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Student entity. Contains personal and academic
 * information about students including enrollment number, name, contact
 * details, and associated college.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_STUDENT")
public class StudentDTO extends BaseDTO {

	@Column(name = "ENROL_NO", length = 20)
	private String enrolNo;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "COLLEGE_ID")
	private Long collegeId;

	@Column(name = "COLLEGE_NAME", length = 50)
	private String collegeName;

	/**
	 * Gets the enrollment number of the student.
	 * 
	 * @return the enrollment number
	 */
	public String getEnrolNo() {
		return enrolNo;
	}

	/**
	 * Sets the enrollment number of the student.
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
	 * Gets the college ID where the student is enrolled.
	 * 
	 * @return the college ID
	 */
	public Long getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets the college ID where the student is enrolled.
	 * 
	 * @param collegeId the college ID to set
	 */
	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Gets the college name where the student is enrolled.
	 * 
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets the college name where the student is enrolled.
	 * 
	 * @param collegeName the college name to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "enrolNo" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "enrolNo";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the enrollment number
	 */
	@Override
	public String getUniqueValue() {
		return enrolNo;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Enroll No" as the label
	 */
	@Override
	public String getLabel() {
		return "Enroll No";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Student" as the table name
	 */
	@Override
	public String getTableName() {
		return "Student";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return the full name (first name + last name)
	 */
	@Override
	public String getValue() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "StudentDTO [enrolNo=" + enrolNo + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", collegeId=" + collegeId + ", collegeName="
				+ collegeName + "]";
	}
}