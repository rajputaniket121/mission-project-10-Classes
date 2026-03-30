package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseForm;
import com.rays.dto.CollegeDTO;

/**
 * Form for College entity.
 * Handles validation and DTO conversion for college data.
 * 
 * @author Aniket Rajput
 */
public class CollegeForm extends BaseForm<CollegeDTO>{
	
	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Address is required")
	private String address;

	@NotEmpty(message = "State is required")
	private String state;

	@NotEmpty(message = "City is required")
	private String city;

	@NotEmpty(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	/**
	 * Gets the college name.
	 * 
	 * @return the college name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the college name.
	 * 
	 * @param name the college name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the college address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the college address.
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the state where college is located.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state where college is located.
	 * 
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the city where college is located.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city where college is located.
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the college phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the college phone number.
	 * 
	 * @param phoneNo the phone number to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Converts the form data to a CollegeDTO.
	 * 
	 * @return the populated CollegeDTO
	 */
	@Override
	public CollegeDTO getDto() {

		CollegeDTO dto = initDTO(new CollegeDTO());
		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);

		return dto;
	}

	@Override
	public String toString() {
		return "CollegeForm [name=" + name + ", address=" + address + ", state=" + state + ", city=" + city
				+ ", phoneNo=" + phoneNo + "]";
	}
}