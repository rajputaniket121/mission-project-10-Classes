package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseForm;
import com.rays.dto.FacultyDTO;

/**
 * Form for Faculty entity. Handles validation and DTO conversion for faculty
 * data including personal details, qualifications, and associated
 * college/course/subject.
 * 
 * @author Aniket Rajput
 */
public class FacultyForm extends BaseForm<FacultyDTO> {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotNull(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	@NotEmpty(message = "Email ID is required")
	private String email;

	@NotEmpty(message = "Qualification is required")
	private String qualification;

	@NotNull(message = "College is required")
	@Min(1)
	private Long collegeId = 0L;

	private String collegeName;

	@NotNull(message = "Course is required")
	@Min(1)
	private Long courseId = 0L;

	private String courseName;

	@NotNull(message = "Subject is required")
	@Min(1)
	private Long subjectId = 0L;

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
	 * Gets the college ID where faculty works.
	 * 
	 * @return the college ID
	 */
	public long getCollegeId() {
		return collegeId;
	}

	/**
	 * Sets the college ID where faculty works.
	 * 
	 * @param collegeId the college ID to set
	 */
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	/**
	 * Gets the college name where faculty works.
	 * 
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * Sets the college name where faculty works.
	 * 
	 * @param collegeName the college name to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Gets the course ID taught by faculty.
	 * 
	 * @return the course ID
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course ID taught by faculty.
	 * 
	 * @param courseId the course ID to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name taught by faculty.
	 * 
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name taught by faculty.
	 * 
	 * @param courseName the course name to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the subject ID taught by faculty.
	 * 
	 * @return the subject ID
	 */
	public long getSubjectId() {
		return subjectId;
	}

	/**
	 * Sets the subject ID taught by faculty.
	 * 
	 * @param subjectId the subject ID to set
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Gets the subject name taught by faculty.
	 * 
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * Sets the subject name taught by faculty.
	 * 
	 * @param subjectName the subject name to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * Converts the form data to a FacultyDTO.
	 * 
	 * @return the populated FacultyDTO
	 */
	@Override
	public FacultyDTO getDto() {

		FacultyDTO dto = initDTO(new FacultyDTO());
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setPhoneNo(phoneNo);
		dto.setEmail(email);
		dto.setQualification(qualification);
		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);
		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setSubjectId(subjectId);
		dto.setSubjectName(subjectName);

		return dto;
	}

	@Override
	public String toString() {
		return "FacultyForm [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", qualification=" + qualification + ", collegeId="
				+ collegeId + ", collegeName=" + collegeName + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
}