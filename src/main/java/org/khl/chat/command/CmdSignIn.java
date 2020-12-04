package org.khl.chat.command;

import org.khl.chat.dto.LoginRequestDto;
import org.khl.chat.dto.UserDto;

public class CmdSignIn extends Command{
	
	private String email;
	private String password;
	
	public CmdSignIn() {
		super();
	}

	@Override
	public String execute() {
		
		if (appData == null) {
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
		else return "Выйдите из учетной записи ($signout)";
	}
	
}
