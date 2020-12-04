package org.khl.chat.command;

import org.khl.chat.dto.UserDto;
import org.khl.chat.exception.IllegalStateException;
import org.khl.chat.exception.InvalidCommandParamException;

public class CmdSignUp extends Command{
	
	private String name;
	private String email;
	private String password;
	private String role;
	
	public CmdSignUp() {
		super();
	}

	@Override
	public String execute() throws IllegalStateException{
	
		if (appData == null)
		{
			System.out.println("Введите имя: ");
			this.name = console.nextLine().trim();
	
			System.out.println("Введите e-mail: ");
		    this.email = console.nextLine().trim();
	
	    	System.out.println("Введите пароль: ");
	    	this.password = console.nextLine().trim();
	    	
	    	this.role = "user";
	    	
			try {
				UserDto uDto = requestService.signUp(new UserDto(this.name, this.email, this.password, this.role));
				
				if (uDto != null) return "Регистрация польователя " + uDto.getName() + " (" + uDto.getEmail() + ") прошла успешно. \nВы можете авторизоваться." ;
				else return "Ошибка регистрации. Проверьте свои данные.";
			} catch (IllegalStateException ex) {
				return ex.getMessage();
			} catch (InvalidCommandParamException e) {
				return e.getMessage();
			}
		}
		else return "Выйдите из учетной записи ($signout)\n";
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
