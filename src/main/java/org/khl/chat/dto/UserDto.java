package org.khl.chat.dto;

import java.util.ArrayList;
import java.util.Collection;

public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String role;
	
	public UserDto(Long id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public UserDto() {}
			
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		String result = "User №" + this.id + " " + this.name + " (" + this.email +")";
		return result;
	}
}
