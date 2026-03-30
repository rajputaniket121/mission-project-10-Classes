package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

/**
 * Form for Subject entity. Handles validation and DTO conversion for subject
 * data including associated course information.
 * 
 * @author Aniket Rajput
 */
public class SubjectForm extends BaseForm<SubjectDTO> {

	@NotNull(message = "Course is required")
	@Min(1)
	private Long courseId = 0L;

	private String courseName;

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Description is required")
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
	 * Converts the form data to a SubjectDTO.
	 * 
	 * @return the populated SubjectDTO
	 */
	@Override
	public SubjectDTO getDto() {

		SubjectDTO dto = initDTO(new SubjectDTO());

		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setName(name);
		dto.setDescription(description);

		return dto;
	}

	@Override
	public String toString() {
		return "SubjectForm [courseId=" + courseId + ", courseName=" + courseName + ", name=" + name + ", description="
				+ description + "]";
	}
}