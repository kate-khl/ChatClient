package org.khl.chat.command;

public class CmdLeaveChat extends Command{

	@Override
	public String execute() throws IllegalStateException {
		appData.setChatId(null);
		return "Вы покинули чат";
	}
	
	

}
