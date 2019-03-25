package com.weyinmi.isack.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name= "users")
public class UserInfo {
	
	@Id
	@GeneratedValue
	@Column(name="userid")
	private Long id;
	
	@Column(name="username")
	@NotEmpty
	private String username;
	
	@Column(name="password")
	@NotEmpty
	private String password;
	
	@Column(name="enabled")
	private boolean isEnabled;
	
	@Column(name="role")
	private String role;
	

}
