package org.khl.chat.command;

import org.springframework.web.client.RestTemplate;

public class SignIn extends Command{

	private String login;
	private String password;
	
	public SignIn() {
		super("SignIn desc");
	}
	
	public SignIn(String inputStr) {
		this();
		this.login = setLoginFromString(inputStr);
		this.password = setPasswordFromString(inputStr);
	}

	@Override
	public String execute(RestTemplate restTemplate) {
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
	
	private String setPasswordFromString(String inputStr) {
		
		int passwordBeginIdx = inputStr.indexOf("password ") + "password ".length();
		int passwordEndIdx = inputStr.length();
		
		char[] password = new char[passwordEndIdx - passwordBeginIdx];
		inputStr.getChars(passwordBeginIdx, passwordEndIdx, password, 0);

		StringBuilder strPassword = new StringBuilder(password.length);
		for (Character c : password)
			strPassword.append(c.charValue());
		
		return strPassword.toString();
	}
	
	private String setLoginFromString(String inputStr) {
		
		int loginBeginIdx = inputStr.indexOf("login ") + "login ".length();
		int loginEndIdx = inputStr.indexOf(" password");
		
		char[] login = new char[loginEndIdx - loginBeginIdx];
		inputStr.getChars(loginBeginIdx, loginEndIdx, login, 0);
		
		StringBuilder strLogin = new StringBuilder(login.length);
		for (Character c : login)
			strLogin.append(c.charValue());
		
		return strLogin.toString();
		 
	}

}
