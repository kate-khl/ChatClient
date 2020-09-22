package org.khl.chat;

import org.khl.chat.service.Command;
import org.khl.chat.service.SettingsService;
import org.khl.chat.service.UserService;

public class CmdScanner {
	
	SettingsService settingsService;
	UserService userService; 
	
	
	public String parse(String inputStr) {
		
		Command cmd = findCmd( inputStr);
		String result = doCmd(cmd);
		return result;
	}
	
	private String doCmd(Command cmd) {

		switch (cmd) { 
			case HELP :
				return settingsService.getHelp(); 
			case LOGIN :
				return ""; 
//				userService.login(login, password)				
			default : return ""; 
		}
		
	}
	
	private Command findCmd(String inputStr) {
		inputStr = inputStr.trim();		
		for (Command cmd : Command.values()) {
			if (inputStr.contains(cmd.getName())) {
				if (inputStr.trim().indexOf(cmd.getName()) == 0) {
					return cmd;
				}
			} 
		}
		return Command.NOT_COMMAND;
	}
}
