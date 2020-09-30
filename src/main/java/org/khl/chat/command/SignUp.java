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
	public String execute() {
	
		UserDto uDto = requestService.signUp(new UserDto(this.name, this.email, this.password, this.role));
		
		if (uDto != null) return "Регистрация польователя " + uDto.getName() + " (" + uDto.getEmail() + ") прошла успешно. \nВы можете авторизоваться." ;
		else return "Ошибка регистрации. Проверьте свои данные.";
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
