package org.khl.chat.command;

public abstract class Command {

	private CommandType commandType;
	private String descriprtion;
	


	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	public String getDescriprtion() {
		return descriprtion;
	}



	public void setDescriprtion(String descriprtion) {
		this.descriprtion = descriprtion;
	}



	public Command(CommandType commandType, String descriprtion) {
		super();
		this.commandType = commandType;
		this.descriprtion = descriprtion;
	}



	public abstract CommandResult execute();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n" + this.getClass().getSimpleName() + ": " + this.getDescriprtion() ;
	}
}
