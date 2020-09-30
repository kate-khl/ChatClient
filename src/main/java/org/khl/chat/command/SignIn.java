package org.khl.chat.command;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class SignIn extends Command{
	
	private String email;
	private String password;
	
	public SignIn() {
		super();
	}
	
	public SignIn(String inputStr) {
		this();
		this.email = getParamValueFromInputString(inputStr, "email");
		this.password = getParamValueFromInputString(inputStr, "password");
	}

	@Override
	public String execute() {
		
		UserDto uDto = requestService.signIn(new LoginRequestDto(this.email, this.password));

		if (uDto != null) 
			return "Вы вошли как " + uDto.getName() + " (" + uDto.getEmail() + ").";
		else return "Ошибка авторизации";
	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
