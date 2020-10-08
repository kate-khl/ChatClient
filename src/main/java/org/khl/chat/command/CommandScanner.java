package org.khl.chat.command;

import org.khl.chat.AppData;
import org.khl.chat.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandScanner {
		
	@Autowired 
	RequestService requestService;
	@Autowired
	private AppData app;
	
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
				cmd = new CmdHelp();
				return cmd;
			}
					
			else if (inputStr.contains("$signin") && (inputStr.indexOf("$signin")== 0)) {
				cmd =  new CmdSignIn(inputStr);
				cmd.setReqService(requestService);
				return cmd;
			}

			else if (inputStr.contains("$signup") && (inputStr.indexOf("$signup")== 0)) {
				cmd = new CmdSignUp(inputStr);
				cmd.setReqService(requestService);
				return cmd;
			}
			else if (inputStr.contains("$getusers") && (inputStr.indexOf("$getusers")== 0)) {
				cmd = new CmdGetUsers();
				cmd.setReqService(requestService);
				cmd.setAppData(app);
				return cmd;
			}

		return null;
	}
	

	

	

	
}
