package com.demo.user.api.entity;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = -6733100728077775487L;

	private Long id;
	
	private String name;
	
	private Date registerDate;

	public Long getId() {
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
}
