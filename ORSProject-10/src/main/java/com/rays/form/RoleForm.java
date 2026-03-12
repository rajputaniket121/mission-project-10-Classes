package com.rays.form;

import javax.validation.constraints.NotEmpty;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

public class RoleForm extends BaseForm<RoleDTO> {
	
	@NotEmpty(message = "Name is Required")
	private String name;
	
	@NotEmpty(message = "Description is Required")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public RoleDTO getDto() {
		RoleDTO dto = initDTO(new RoleDTO());
		dto.setName(name);
		dto.setDescription(description);
		return dto;
	}
	

}
