package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Data Transfer Object for College entity.
 * Contains information about educational institutions including name, address,
 * state, city, and contact details.
 * 
 * @author Aniket Rajput
 */
@Table(name = "ST_COLLEGE")
@Entity
public class CollegeDTO extends BaseDTO {
	
	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "ADDRESS", length = 50)
	private String address;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "CITY", length = 50)
	private String city;

	@Column(name = "PHONE_NO", length = 15)
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
	 * Gets the state where the college is located.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state where the college is located.
	 * 
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the city where the college is located.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city where the college is located.
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
	 * Gets the display value for dropdown lists.
	 * 
	 * @return the college name
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
	 * @return the college name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Gets the display label for this DTO.
	 * 
	 * @return "College Name" as the label
	 */
	@Override
	public String getLabel() {
		return "College Name";
	}

	/**
	 * Gets the table name for this DTO.
	 * 
	 * @return "College" as the table name
	 */
	@Override
	public String getTableName() {
		return "College";
	}

	@Override
	public String toString() {
		return "CollegeDTO [name=" + name + ", address=" + address + ", state=" + state + ", city=" + city
				+ ", phoneNo=" + phoneNo + "]";
	}
}