package org.khl.chat.command;

public class CmdSignOut extends Command{

	@Override
	public String execute() throws IllegalStateException {
//			appData.setEmail(null);
//			appData.setExpMillis(null);
//			appData.setId(null);
//			appData.setName(null);
//			appData.setPassword(null);
//			appData.setToken(null);
		appData = null;
		return description;
	}
}
