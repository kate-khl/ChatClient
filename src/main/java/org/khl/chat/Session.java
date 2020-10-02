package org.khl.chat;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public final class Session {
	 
	private Long id;
	private String name;
	private String email;
    private String token;
    private Date exp;
    
    private Session() {        
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

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

}
