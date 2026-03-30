package com.rays.form;

import javax.validation.constraints.NotEmpty;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

/**
 * Form for Role entity.
 * Handles validation and DTO conversion for role data.
 * 
 * @author Aniket Rajput
 */
public class RoleForm extends BaseForm<RoleDTO> {
	
	@NotEmpty(message = "Name is Required")
	private String name;
	
	@NotEmpty(message = "Description is Required")
	private String description;

	/**
	 * Gets the role name.
	 * 
	 * @return the role name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the role name.
	 * 
	 * @param name the role name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the role description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the role description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Converts the form data to a RoleDTO.
	 * 
	 * @return the populated RoleDTO
	 */
	@Override
	public RoleDTO getDto() {
		RoleDTO dto = initDTO(new RoleDTO());
		dto.setName(name);
		dto.setDescription(description);
		return dto;
	}

	@Override
	public String toString() {
		return "RoleForm [name=" + name + ", description=" + description + "]";
	}
}