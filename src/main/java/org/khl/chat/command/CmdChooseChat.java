package org.khl.chat.command;

public class CmdChooseChat extends Command{

	Long chatId;
	
	@Override
	public String execute() throws IllegalStateException {
		appData.setChatId(chatId);
		return "Выбран чат №" + chatId + "Для завершения диалога введите команду $leavechat";
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
}
