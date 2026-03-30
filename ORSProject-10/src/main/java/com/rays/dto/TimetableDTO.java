package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Timetable entity.
 * Contains scheduling information for exams including course, subject,
 * exam date, time, and semester details.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_TIMETABLE")
public class TimetableDTO extends BaseDTO {

	@Column(name = "COURSE_ID", length = 50)
	private long courseId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	@Column(name = "SUBJECT_ID", length = 50)
	private long subjectId;

	@Column(name = "SUBJECT_NAME", length = 50)
	private String subjectName;

	@Column(name = "EXAM_DATE")
	private Date examDate;

	@Column(name = "EXAM_TIME", length = 50)
	private String examTime;

	@Column(name = "SEMESTER", length = 30)
	private String semester;

	@Column(name = "DESCRIPTION", length = 50)
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
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "courseName" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "courseName";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the course name
	 */
	@Override
	public String getUniqueValue() {
		return courseName;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return null as timetable is not typically used in dropdowns
	 */
	@Override
	public String getLabel() {
		return null;
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "TimeTable" as the table name
	 */
	@Override
	public String getTableName() {
		return "TimeTable";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return null as timetable is not typically used in dropdowns
	 */
	@Override
	public String getValue() {
		return null;
	}

	@Override
	public String toString() {
		return "TimetableDTO [courseId=" + courseId + ", courseName=" + courseName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", examDate=" + examDate + ", examTime=" + examTime + ", semester="
				+ semester + ", description=" + description + "]";
	}
}