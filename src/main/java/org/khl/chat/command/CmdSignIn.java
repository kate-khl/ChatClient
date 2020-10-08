package org.khl.chat.command;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;
import org.khl.chat.exception.IllegalStateException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class CmdSignIn extends Command{
	
	private String email;
	private String password;
	
	public CmdSignIn() {
		super();
	}
	
	public CmdSignIn(String inputStr) {
		this();
		this.email = getParamValueFromInputString("email", inputStr);
		this.password = getParamValueFromInputString("password", inputStr);
	}

	@Override
	public String execute() {
		
		try {
			UserDto uDto = requestService.signIn(new LoginRequestDto(this.email, this.password));
			return "Вы вошли как " + uDto.getName() + " (" + uDto.getEmail() + ").";
		}
		catch (RuntimeException ex) {
			return ex.getMessage();
		}
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
