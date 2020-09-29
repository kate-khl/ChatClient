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
	
	private static final String URL_SIGN_IN = "http://127.0.0.1:8080/auth";
	
	public SignIn() {
		super();
	}
	
	public SignIn(String inputStr) {
		this();
		this.email = getParamValueFromInputString(inputStr, "email");
		this.password = getParamValueFromInputString(inputStr, "password");
	}

	@Override
	public String execute(RestTemplate restTemplate) {

		try {
			HttpEntity<LoginRequestDto> requestBody = new HttpEntity<>(new LoginRequestDto(this.email, this.password));
			String result = restTemplate.postForObject(URL_SIGN_IN, requestBody, String.class);
			return result;
		}
		catch (HttpClientErrorException ex) {
			return ex.getStatusCode().toString() + " : " + ex.getMessage();
		}
		catch (HttpServerErrorException ex) {
			return ex.getStatusCode().toString();
		}
	}

	public String getLogin() {
		return email;
	}

	public void setLogin(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
