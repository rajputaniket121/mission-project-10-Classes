package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for Role entity.
 * Defines user roles in the system (e.g., Admin, Student, Faculty)
 * with associated permissions.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_ROLE")
public class RoleDTO extends BaseDTO {
	
	@Column(name = "Name",length = 20)
	private String name;
	
	@Column(name = "DESCRIPTION",length = 100)
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
	 * Gets the display value for dropdown lists.
	 * 
	 * @return the role name
	 */
	@Override
	public String getValue() {
		return name;
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
	 * @return the role name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Role Name" as the label
	 */
	@Override
	public String getLabel() {
		return "Role Name";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "Role" as the table name
	 */
	@Override
	public String getTableName() {
		return "Role";
	}

	@Override
	public String toString() {
		return "RoleDTO [name=" + name + ", description=" + description + ", id=" + id + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdDateTime=" + createdDateTime + ", modifiedDateTime="
				+ modifiedDateTime + "]";
	}
}