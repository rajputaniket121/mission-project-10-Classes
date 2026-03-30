package com.rays.dto;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for file attachments.
 * Stores file metadata and binary content for user profile pictures and other attachments.
 * 
 * @author Aniket Rajput
 */
@Entity
@Table(name = "ST_ATTACHMENT")
public class AttachmentDTO extends BaseDTO {

	@Column(name = "NAME", length = 100)
	protected String name = null;

	@Column(name = "TYPE", length = 100)
	protected String type = null;

	@Column(name = "DESCRIPTION", length = 500)
	protected String description = null;

	@Column(name = "USER_ID")
	protected Long userId = null;

	@Lob
	@Column(name = "DOC")
	private byte[] doc;

	/**
	 * Default constructor.
	 */
	public AttachmentDTO() {
	}

	/**
	 * Constructor that creates an AttachmentDTO from a MultipartFile.
	 * Extracts file name, content type, and binary data from the uploaded file.
	 * 
	 * @param file the uploaded multipart file
	 */
	public AttachmentDTO(MultipartFile file) {
		name = file.getOriginalFilename();
		type = file.getContentType();

		try {
			doc = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the file name.
	 * 
	 * @return the file name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the file name.
	 * 
	 * @param name the file name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the file content type.
	 * 
	 * @return the content type (e.g., image/jpeg, image/png)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the file content type.
	 * 
	 * @param type the content type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the description of the attachment.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the attachment.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the user ID associated with this attachment.
	 * 
	 * @return the user ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user ID associated with this attachment.
	 * 
	 * @param userId the user ID to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the display value for dropdown lists.
	 * 
	 * @return null as attachment is not used in dropdowns
	 */
	public String getValue() {
		return null;
	}

	/**
	 * Gets the binary data of the file.
	 * 
	 * @return the byte array containing file content
	 */
	public byte[] getDoc() {
		return doc;
	}

	/**
	 * Sets the binary data of the file.
	 * 
	 * @param doc the byte array to set
	 */
	public void setDoc(byte[] doc) {
		this.doc = doc;
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
	 * @return the file name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "Image" as the label
	 */
	@Override
	public String getLabel() {
		return "Image";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "ATTACHMENT" as the table name
	 */
	@Override
	public String getTableName() {
		return "ATTACHMENT";
	}
}