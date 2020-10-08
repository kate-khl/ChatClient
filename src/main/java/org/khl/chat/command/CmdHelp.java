package org.khl.chat.command;

public class CmdHelp  extends Command{
	
	public CmdHelp() {
		super();
	}

	@Override
	public String execute() {
		
		return Command.description;
	}

}
