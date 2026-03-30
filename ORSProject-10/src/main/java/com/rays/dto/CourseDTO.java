package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Course entity.
 * Contains information about academic courses including name, duration, and description.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_COURSE")
public class CourseDTO extends BaseDTO {

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DURATION", length = 50)
	private String duration;

	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	/**
	 * Gets the course name.
	 * 
	 * @return the course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the course name.
	 * 
	 * @param name the course name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the course duration.
	 * 
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Sets the course duration.
	 * 
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Gets the course description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the course description.
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
	 * @return the course name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Course Name" as the label
	 */
	@Override
	public String getLabel() {
		return "Course Name";
	}
	
	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Course" as the table name
	 */
	@Override
	public String getTableName() {
		return "Course";
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return the course name
	 */
	@Override
	public String getValue() {
		return name;
	}

	@Override
	public String toString() {
		return "CourseDTO [name=" + name + ", duration=" + duration + ", description=" + description + "]";
	}
}