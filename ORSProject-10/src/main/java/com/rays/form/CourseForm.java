package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;
import com.rays.dto.CourseDTO;

/**
 * Form for Course entity.
 * Handles validation and DTO conversion for course data.
 * 
 * @author Aniket Rajput
 */
public class CourseForm extends BaseForm<CourseDTO> {
	
	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Duration is required")
	private String duration;

	@NotEmpty(message = "Description is required")
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
	 * Converts the form data to a CourseDTO.
	 * 
	 * @return the populated CourseDTO
	 */
	@Override
	public CourseDTO getDto() {

		CourseDTO dto = initDTO(new CourseDTO());
		dto.setName(name);
		dto.setDuration(duration);
		dto.setDescription(description);

		return dto;
	}

	@Override
	public String toString() {
		return "CourseForm [name=" + name + ", duration=" + duration + ", description=" + description + "]";
	}
}