package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base Data Transfer Object class providing common fields and functionality
 * for all DTOs in the application. Contains audit fields like created by,
 * modified by, and timestamps.
 * 
 * @author Aniket Rajput
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList{
	
	@Id
	@GeneratedValue(generator = "pk")
	@GenericGenerator(name = "pk",strategy = "native")
	@Column(name = "ID",nullable = false,unique = true)
	protected Long id;
	
	@Column(name = "CREATED_BY",length = 50)
	protected String createdBy;
	@Column(name = "MODIFIED_BY",length = 50)
	protected String modifiedBy;
	
	@Column(name = "CREATED_DATETIME")
	protected Timestamp createdDateTime;
	@Column(name = "MODIFIED_DATETIME")
	protected Timestamp modifiedDateTime;
	
	/**
	 * Gets the unique key attribute name for uniqueness validation.
	 * 
	 * @return the name of the unique key attribute
	 */
	public abstract String getUniqueKey();
	
	/**
	 * Gets the unique key value for uniqueness validation.
	 * 
	 * @return the value of the unique key attribute
	 */
	public abstract String getUniqueValue();
	
	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return the display label
	 */
	public abstract String getLabel();
	
	/**
	 * Gets the table name associated with this DTO.
	 * 
	 * @return the database table name
	 */
	public abstract String getTableName();
	
	/**
	 * Gets the key value for dropdown list display.
	 * 
	 * @return the ID as a string for dropdown key
	 */
	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	
	/**
	 * Gets the ID of the DTO.
	 * 
	 * @return the ID value
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the ID of the DTO.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the user who created this record.
	 * 
	 * @return the created by username
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * Sets the user who created this record.
	 * 
	 * @param createdBy the created by username to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Gets the user who last modified this record.
	 * 
	 * @return the modified by username
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	/**
	 * Sets the user who last modified this record.
	 * 
	 * @param modifiedBy the modified by username to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	/**
	 * Gets the creation timestamp of this record.
	 * 
	 * @return the created timestamp
	 */
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}
	
	/**
	 * Sets the creation timestamp of this record.
	 * 
	 * @param createdDateTime the created timestamp to set
	 */
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	/**
	 * Gets the last modification timestamp of this record.
	 * 
	 * @return the modified timestamp
	 */
	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}
	
	/**
	 * Sets the last modification timestamp of this record.
	 * 
	 * @param modifiedDateTime the modified timestamp to set
	 */
	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
	
	@Override
	public String toString() {
		return "BaseDTO [id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDateTime="
				+ createdDateTime + ", modifiedDateTime=" + modifiedDateTime + "]";
	}
	
}