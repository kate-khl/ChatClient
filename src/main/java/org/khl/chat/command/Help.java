package org.khl.chat.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class Help  extends Command{

//	@Autowired
//	private Set<Command> cmds;
	@Autowired
	private CommandResult result;
	
	public Help() {
		super("Help desc");
	}

	@Override
	public String execute(RestTemplate restTemplate) {
		
		String resultStr = 
				SignIn.class.getSimpleName() + " - " + new SignIn().descriprtion + "\n" 
			  + SignUp.class.getSimpleName() + " - " + new SignUp().descriprtion + "\n"
			  + Help.class.getSimpleName() + " - " + this.descriprtion + "\n";
//		result.setResultString(resultStr);
		return resultStr;
	}

}
