package org.khl.chat.command;

public class CmdSendMessage extends Command{

	@Override
	public String execute() throws IllegalStateException {
		
		if (appData.getChatId() != null) {
			String msg = console.nextLine().trim();
			requestService.sendMessage(appData.getToken(), appData.getChatId(), msg);
			return msg + "\n";
		}
		else return "Чат не выбран";
	}

}
