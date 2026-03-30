package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.TimetableDTO;

/**
 * Form for Timetable entity.
 * Handles validation and DTO conversion for exam schedule data including
 * course, subject, exam date, time, and semester details.
 * 
 * @author Aniket Rajput
 */
public class TimetableForm extends BaseForm<TimetableDTO> {
	
	@NotNull(message = "Course is required")
	@Min(1)
	private Long courseId = 0L;

	private String courseName;

	@NotNull(message = "Subject is required")
	@Min(1)
	private Long subjectId = 0L;

	private String subjectName;

	@NotNull(message = "Exam Date is required")
	private Date examDate;

	@NotEmpty(message = "Exam Time is required")
	private String examTime;

	@NotEmpty(message = "Semester is required")
	private String semester;

	@NotEmpty(message = "Description is required")
	private String description;

	/**
	 * Gets the course ID for this timetable entry.
	 * 
	 * @return the course ID
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course ID for this timetable entry.
	 * 
	 * @param courseId the course ID to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name for this timetable entry.
	 * 
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name for this timetable entry.
	 * 
	 * @param courseName the course name to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the subject ID for this timetable entry.
	 * 
	 * @return the subject ID
	 */
	public long getSubjectId() {
		return subjectId;
	}

	/**
	 * Sets the subject ID for this timetable entry.
	 * 
	 * @param subjectId the subject ID to set
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Gets the subject name for this timetable entry.
	 * 
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * Sets the subject name for this timetable entry.
	 * 
	 * @param subjectName the subject name to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * Gets the exam date.
	 * 
	 * @return the exam date
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * Sets the exam date.
	 * 
	 * @param examDate the exam date to set
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	/**
	 * Gets the exam time.
	 * 
	 * @return the exam time
	 */
	public String getExamTime() {
		return examTime;
	}

	/**
	 * Sets the exam time.
	 * 
	 * @param examTime the exam time to set
	 */
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	/**
	 * Gets the semester.
	 * 
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * Sets the semester.
	 * 
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Converts the form data to a TimetableDTO.
	 * 
	 * @return the populated TimetableDTO
	 */
	@Override
	public TimetableDTO getDto() {

		TimetableDTO dto = initDTO(new TimetableDTO());
		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setSubjectId(subjectId);
		dto.setSubjectName(subjectName);
		dto.setExamDate(examDate);
		dto.setExamTime(examTime);
		dto.setSemester(semester);
		dto.setDescription(description);

		return dto;
	}

	@Override
	public String toString() {
		return "TimetableForm [courseId=" + courseId + ", courseName=" + courseName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", examDate=" + examDate + ", examTime=" + examTime + ", semester="
				+ semester + ", description=" + description + "]";
	}
}