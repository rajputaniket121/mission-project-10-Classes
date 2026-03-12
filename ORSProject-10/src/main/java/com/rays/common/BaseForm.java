package com.rays.common;

public class BaseForm<T extends BaseDTO> {
	
	protected long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public T getDto() {
		return null;
	}
	
	public T initDTO(T dto) {
		System.out.println("id => base dto => " + id);
		if(id > 0) {
			dto.setId(id);
		}else {
			dto.setId(0);
		}
		return dto;
	}
	
}
