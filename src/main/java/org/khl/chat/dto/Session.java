package org.khl.chat.dto;

import java.util.Base64;
import java.util.Date;

import com.google.gson.Gson;

public class Session {

	private Long id;
	private String name;
	private String email;
	private String password;
    private Long exp;
//    private Date expDate;
    
	public static Session getFromToken(String token) {
		token = token.replace("_", "+").replace("-", "/");
		
		String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];		
        
        String body = new String(Base64.getMimeDecoder().decode(base64EncodedBody));
        Gson gson = new Gson();
        Session ss = gson.fromJson(body, Session.class);
    //    ss.setExpDateFromUnix(ss.exp);

        return ss;
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
	public Long getExp() {
		return exp*1000;
	}
	public void setExp(Long exp) {
		this.exp = exp;
	}

//	public Date getExpDate() {
//		return expDate;
//	}
//
//	public void setExpDate(Date expDate) {
//		this.expDate = expDate;
//	}
//    
//	public void setExpDateFromUnix(Long unixDate) {
//		this.expDate = new Date(unixDate*1000);
//	}
	
	
    
}
