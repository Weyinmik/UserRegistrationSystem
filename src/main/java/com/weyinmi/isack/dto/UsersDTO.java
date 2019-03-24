package com.weyinmi.isack.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Users")
public class UsersDTO {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	
	@NotEmpty
	@Length(max = 50)
	@Column(name = "NAME")
	private String name;
	
	@NotEmpty
	@Length(max = 150)
	@Column(name = "ADDRESS")
	private String address;
	
	@Email
	@NotEmpty
	@Length(max = 80)
	@Column(name = "EMAIL")
	private String email;
	
	 //Getters and Setters Method
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getErrorMessage() {
		return null;
	}
	

}