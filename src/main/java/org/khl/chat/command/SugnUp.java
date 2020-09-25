package org.khl.chat.command;

import org.springframework.stereotype.Component;

@Component
public class SugnUp extends Command{

	public SugnUp() {
		super(CommandType.SIGN_UP, "SignUp desc");
	}

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
