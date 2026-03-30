package com.rays.common;

/**
 * Base Form class for handling request data binding and DTO initialization.
 * 
 * @author Aniket Rajput
 * @param <T> DTO type extending BaseDTO
 */
public class BaseForm<T extends BaseDTO> {
	
	protected Long id;

	/**
	 * Gets the ID of the form.
	 * 
	 * @return the ID value
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the form.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the DTO associated with this form.
	 * 
	 * @return the DTO instance, null by default (to be overridden)
	 */
	public T getDto() {
		return null;
	}
	
	/**
	 * Initializes the DTO with the form's ID if present.
	 * 
	 * @param dto the DTO to initialize
	 * @return the initialized DTO with ID set if applicable
	 */
	public T initDTO(T dto) {
		System.out.println("id => base dto => " + id);
		if(id !=null && id > 0) {
			dto.setId(id);
		}else {
			dto.setId(null);
		}
		return dto;
	}
	
}