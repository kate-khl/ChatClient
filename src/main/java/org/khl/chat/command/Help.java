package org.khl.chat.command;

public class Help  extends Command{
	
	public Help() {
		super();
	}

	@Override
	public String execute() {
		
		return Command.description;
	}

}
