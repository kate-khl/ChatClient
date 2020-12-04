package org.khl.chat.command;

public class CmdSignOut extends Command{

	@Override
	public String execute() throws IllegalStateException {
		appData = null;
		return description;
	}
}
