package org.khl.chat.command;

public class CmdSendMessage extends Command{

	@Override
	public String execute() throws IllegalStateException {
		String msg = console.nextLine().trim();
		System.out.println(msg + "/n");
		return null;
	}

}
