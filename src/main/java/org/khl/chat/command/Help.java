package org.khl.chat.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class Help  extends Command{
	
	public Help() {
		super();
	}

	@Override
	public String execute(RestTemplate restTemplate) {
		
		return Command.description;
	}

}
