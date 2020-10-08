package org.khl.chat;

import java.util.Base64;
import java.util.Date;

import org.khl.chat.dto.Session;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public final class AppData {
	 
	private Long id;
	private String name;
	private String email;
	private String password;
    private Date expDate;
    private String token;
    
    private AppData() {        
    }
    
    public void setFieldsFromSession(Session s) {
    	this.id = s.getId();
    	this.email = s.getEmail();
    	this.name = s.getName();
    	this.password = s.getPassword();
    	this.expDate = s.getExpDate();
    }
    
//    public boolean verifyToken() {
//    	if
//    }
    
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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
	
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

}
