package org.khl.chat.command;

public abstract class Command {

	CommandType commandType;
	
	public Command(CommandType commandType) {
		super();
		this.commandType = commandType;
	}

	public abstract CommandResult execute();
}
