package org.khl.chat.command;

import org.khl.chat.Application;
import org.khl.chat.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandScanner {
		
	@Autowired 
	RequestService requestService;
	
	private Application app;
	
	public String parse(String inputStr) {
		
		Command cmd = getCmd( inputStr);
		if (cmd != null)
			return cmd.execute();
		else return "Неверная команда\n";
	}
	
	
	private Command getCmd(String inputStr) {
		Command cmd;
		inputStr = inputStr.trim();	
		
			if (inputStr.contains("$help") && (inputStr.indexOf("$help")== 0)) {
				cmd = new Help();
				return cmd;
			}
					
			else if (inputStr.contains("$signin") && (inputStr.indexOf("$signin")== 0)) {
				cmd =  new SignIn(inputStr);
				cmd.setReqService(requestService);
				return cmd;
			}

			else if (inputStr.contains("$signup") && (inputStr.indexOf("$signup")== 0)) {
				cmd = new SignUp(inputStr);
				cmd.setReqService(requestService);
				return cmd;
			}

		return null;
	}
	

	

	

	
}
