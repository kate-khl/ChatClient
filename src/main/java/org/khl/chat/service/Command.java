package org.khl.chat.service;

public enum Command {

	HELP ("help"),
	LOGIN ("login"),
	NOT_COMMAND("");
	
	private String name;

	Command(String name) {
		this.name = name;
	}
	
	public String getName() {
		return  this.name;
	}
}
