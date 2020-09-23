package org.khl.chat;

import org.khl.chat.command.Command;
import org.khl.chat.command.CommandResult;
import org.khl.chat.command.CommandType;
import org.khl.chat.command.Help;
import org.khl.chat.command.SignIn;
import org.khl.chat.service.SettingsService;
import org.khl.chat.service.UserService;

public class CommandScanner {
	
	SettingsService settingsService;
	UserService userService; 
	
	
	public CommandResult parse(String inputStr) {
		
		Command cmd = getCmd( inputStr);
		return cmd.execute();
	}
	
	
	private Command getCmd(String inputStr) {
		inputStr = inputStr.trim();		
		for (CommandType cmdType : CommandType.values()) {
			
			if (inputStr.contains(cmdType.getName())) {
				
				if (inputStr.indexOf(cmdType.getName()) == 0) {
					
					if (cmdType == CommandType.HELP) 
						return new Help(cmdType); 
					
					if (cmdType == CommandType.SIGN_IN) {
						
						return getSignInCommand(inputStr);
					}
					
				}
			} 
		}
		return null;
	}
	
	private SignIn getSignInCommand(String str) {
		
		int loginBeginIdx = str.lastIndexOf("login ");
		int loginEndIdx = str.indexOf(" password");
		
		char[] login = new char[loginEndIdx - loginBeginIdx];
		str.getChars(loginBeginIdx, loginEndIdx, login, 0);
		
		int passwordBeginIdx = str.lastIndexOf("password ");
		int passwordEndIdx = str.length();
		
		char[] password = new char[passwordEndIdx - passwordBeginIdx];
		str.getChars(passwordBeginIdx, passwordEndIdx, password, 0);
		
		StringBuilder strLogin = new StringBuilder(login.length);
		for (Character c : login)
			strLogin.append(c.charValue());

		StringBuilder strPassword = new StringBuilder(password.length);
		for (Character c : password)
			strPassword.append(c.charValue());
		
		return  new SignIn(CommandType.SIGN_IN, strLogin.toString(), strPassword.toString());
	}
}
