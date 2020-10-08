package org.khl.chat.command;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;

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
		
	    System.out.println("Введите логин: ");
	    this.email = console.nextLine().trim();

    	System.out.println("Введите пароль: ");
    	this.password = console.nextLine().trim();
		
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
