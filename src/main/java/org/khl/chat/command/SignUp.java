package org.khl.chat.command;

import org.khl.chat.dto.UserDto;
import org.khl.chat.exception.InvalidCommandParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class SignUp extends Command{

	private String name;
	private String email;
	private String password;
	private String role;
	RestTemplate restTemplate;
	private static final String URL_SIGN_UP = "http://localhost:8080/registration";
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	public SignUp() {
		super("Sign desc");
	}
	
	public SignUp(String inputStr) {
		this();
		this.email = getParamValueFromInputString(inputStr, "email");
		this.password = getParamValueFromInputString(inputStr, "password");
		this.name = getParamValueFromInputString(inputStr, "name");
		this.role = "user";
	}

	@Override
	public String execute(RestTemplate restTemplate) {
	
		HttpEntity<UserDto> requestBody = new HttpEntity<>(new UserDto(100L, this.name, this.email, this.password, this.role));
		ResponseEntity<UserDto> result = restTemplate.postForEntity(URL_SIGN_UP, requestBody, UserDto.class);
		return result.toString();
	}

	public String getLogin() {
		return email;
	}

	public void setLogin(String login) {
		this.email = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private String getParamValueFromInputString(String inputStr, String param) {
		int loginBeginIdx = 0;
		int loginEndIdx = 0;
		
		if (inputStr.indexOf("-" + param + " ") != -1)
		{
			loginBeginIdx = inputStr.indexOf("-" + param + " ") + ("-" + param + " ").length();
		
			if (inputStr.indexOf(" ", loginBeginIdx) != -1) 
				loginEndIdx = inputStr.indexOf(" ", loginBeginIdx);
			else 
				loginEndIdx = inputStr.length();	
		}
		
		if (loginEndIdx - loginBeginIdx > 1)
		{
			char[] result = new char[loginEndIdx - loginBeginIdx];
			inputStr.getChars(loginBeginIdx, loginEndIdx, result, 0);
			
			StringBuilder strResult = new StringBuilder(result.length);
			for (Character c : result)
				strResult.append(c.charValue());
			
			return strResult.toString();
		}
		else 
			 throw new InvalidCommandParamException("Field value error");
	}

}
