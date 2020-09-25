package org.khl.chat.command;

import org.springframework.stereotype.Component;

@Component
public class SignIn extends Command{

	private String login;
	private String password;

	
	
	public SignIn() {
		super(CommandType.SIGN_IN, "signin desc");
	}

	public SignIn(String login, String password) {
		super(CommandType.SIGN_IN, "SignIn desc");
		this.login = login;
		this.password = password;
	}

//	public SignIn(String login, String password) {
//		super(commandType, "SignIn desc");
//		this.login = login;
//		this.password = password;
//	}

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
