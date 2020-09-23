package org.khl.chat.command;

public enum CommandType {

	HELP ("help"),
	SIGN_IN ("login");
	
	private String name;

	CommandType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return  this.name;
	}
}
