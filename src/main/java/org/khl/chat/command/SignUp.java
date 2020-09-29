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
		super();
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
		return "Вы зарегистрированы: " + result.getBody().toString() +"\nДля входа введите: $singin -email your@email.com -password yourpassword\n" ;
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
	


}
