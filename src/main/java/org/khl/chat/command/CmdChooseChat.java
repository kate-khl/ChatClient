package org.khl.chat.command;

public class CmdChooseChat extends Command{

	Long chatId;
	
	@Override
	public String execute() throws IllegalStateException {
		
	    try {
	    	System.out.println("Введите номер чата : \n");
	    	this.chatId = Long.parseLong(console.nextLine().trim());
	    	appData.setChatId(chatId);
	    	return "Выбран чат №" + chatId + " Для завершения диалога введите команду $leavechat\n";
	    } catch (RuntimeException e) {
				return e.getMessage();
		}
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
	
}
