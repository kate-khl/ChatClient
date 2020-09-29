package org.khl.chat;

import org.khl.chat.command.Command;
import org.khl.chat.command.CommandResult;
import org.khl.chat.command.Help;
import org.khl.chat.command.SignIn;
import org.khl.chat.command.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandScanner {
		
	@Autowired
	private RestTemplate restTemplate;
	
	public String parse(String inputStr) {
		
		Command cmd = getCmd( inputStr);
		return cmd.execute(restTemplate);
	}
	
	
	private Command getCmd(String inputStr) {
		inputStr = inputStr.trim();		
			if (inputStr.contains("help") && (inputStr.indexOf("help")== 0)) 
				return new Help();
					
			if (inputStr.contains("signin") && (inputStr.indexOf("signin")== 0)) 
				return new SignIn(inputStr);

			if (inputStr.contains("signup") && (inputStr.indexOf("signup")== 0)) 
				return new SignUp(inputStr);

		return null;
	}
	

	

	

	
}
