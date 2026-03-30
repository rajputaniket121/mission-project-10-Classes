package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Subject entity.
 * Contains information about academic subjects and their associated courses.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_SUBJECT")
public class SubjectDTO extends BaseDTO {

	@Column(name = "COURSE_ID", length = 50)
	private long courseId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	/**
	 * Gets the course ID associated with this subject.
	 * 
	 * @return the course ID
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * Sets the course ID associated with this subject.
	 * 
	 * @param courseId the course ID to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * Gets the course name associated with this subject.
	 * 
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets the course name associated with this subject.
	 * 
	 * @param courseName the course name to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the subject name.
	 * 
	 * @return the subject name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the subject name.
	 * 
	 * @param name the subject name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the subject description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the subject description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the unique key attribute name for validation.
	 * 
	 * @return "name" as the unique key
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Gets the unique key value for validation.
	 * 
	 * @return the subject name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Subject Name" as the label
	 */
	@Override
	public String getLabel() {
		return "Subject Name";
	}
	
	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Subject" as the table name
	 */
	@Override
	public String getTableName() {
		return "Subject";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return the subject name
	 */
	@Override
	public String getValue() {
		return name;
	}

	@Override
	public String toString() {
		return "SubjectDTO [courseId=" + courseId + ", courseName=" + courseName + ", name=" + name + ", description="
				+ description + "]";
	}
}