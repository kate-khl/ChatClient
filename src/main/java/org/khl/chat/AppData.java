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
    private Long expMillis;
    private String token;
    
    private AppData() {        
    }
    
    public void setFieldsFromSession(Session s) {
    	this.id = s.getId();
    	this.email = s.getEmail();
    	this.name = s.getName();
    	this.password = s.getPassword();
    	this.expMillis = s.getExp();
    }
    
    public boolean validToken() {
    	System.out.println(System.currentTimeMillis());
    	if(this.token != null && this.expMillis > System.currentTimeMillis())
    		return true;
    	else return false;
    	
    }
    
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
	
	public Long getExpMillis() {
		return expMillis;
	}

	public void setExpMillis(Long expDate) {
		this.expMillis = expDate;
	}

}
