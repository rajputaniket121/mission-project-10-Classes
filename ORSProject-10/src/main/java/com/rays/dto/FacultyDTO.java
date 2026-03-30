package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Faculty entity.
 * Contains information about faculty members including personal details,
 * qualifications, and associated college, course, and subject.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_FACULTY")
public class FacultyDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER", length = 10)
	private String gender;

	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "QUALIFICATION", length = 15)
	private String qualification;

	@Column(name = "COLLEGE_ID", length = 50)
	private long collegeId;

	@Column(name = "COLLEGE_NAME", length = 50)
	private String collegeName;

	@Column(name = "COURSE_ID", length = 50)
	private long courseId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	@Column(name = "SUBJECT_ID", length = 50)
	private long subjectId;

	@Column(name = "SUBJECT_NAME", length = 50)
	private String subjectName;

	/**
	 * Gets the faculty member's first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the faculty member's first name.
	 * 
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the faculty member's last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the faculty member's last name.
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the faculty member's date of birth.
	 * 
	 * @return the date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the faculty member's date of birth.
	 * 
	 * @param dob the date of birth to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * Gets the faculty member's gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the faculty member's gender.
	 * 
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the faculty member's phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the faculty member's phone number.
	 * 
	 * @param phoneNo the phone number to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the faculty member's email address.
	 * 
	 * @return the email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the faculty member's email address.
	 * 
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the faculty member's qualification.
	 * 
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * Sets the faculty member's qualification.
	 * 
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * Gets the college ID where the faculty member works.
	 * 
	 * @return the college ID
	 */
	public long getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets the college ID where the faculty member works.
	 * 
	 * @param collegeId the college ID to set
	 */
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Gets the college name where the faculty member works.
	 * 
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets the college name where the faculty member works.
	 * 
	 * @param collegeName the college name to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Gets the course ID taught by the faculty member.
	 * 
	 * @return the course ID
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course ID taught by the faculty member.
	 * 
	 * @param courseId the course ID to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name taught by the faculty member.
	 * 
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name taught by the faculty member.
	 * 
	 * @param courseName the course name to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the subject ID taught by the faculty member.
	 * 
	 * @return the subject ID
	 */
	public long getSubjectId() {
		return subjectId;
	}

	/**
	 * Sets the subject ID taught by the faculty member.
	 * 
	 * @param subjectId the subject ID to set
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Gets the subject name taught by the faculty member.
	 * 
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * Sets the subject name taught by the faculty member.
	 * 
	 * @param subjectName the subject name to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "email" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "email";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the email address
	 */
	@Override
	public String getUniqueValue() {
		return email;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Email" as the label
	 */
	@Override
	public String getLabel() {
		return "Email";
	}
	
	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Faculty" as the table name
	 */
	@Override
	public String getTableName() {
		return "Faculty";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return null as faculty is not typically used in dropdowns
	 */
	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String toString() {
		return "FacultyDTO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", qualification=" + qualification + ", collegeId="
				+ collegeId + ", collegeName=" + collegeName + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
}