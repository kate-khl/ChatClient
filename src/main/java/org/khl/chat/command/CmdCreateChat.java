package org.khl.chat.command;

import java.util.ArrayList;
import java.util.Collection;

import org.khl.chat.dto.ChatDto;
import org.khl.chat.dto.CreateChatRequest;
import org.khl.chat.exception.StringFormatException;

public class CmdCreateChat extends Command {

	private Collection<Long> userIds;
	private String message;
	private String name;
	
	@Override
	public String execute() throws IllegalStateException {
		
	    try {
	    	System.out.println("Введите название чата : \n");
	    	this.name = console.nextLine().trim();
	    	
	    	System.out.println("Введите идентификаторы участников (пример: 1 34 5): \n");
		    this.userIds = getUserIdsFromString(console.nextLine());

		    System.out.println("Введите приветствие: \n");
		    this.message = console.nextLine().trim();

			CreateChatRequest createChatReq = new CreateChatRequest(this.userIds, this.name, this.message);
			ChatDto chat = requestService.createChat(appData.getToken(), createChatReq);

			appData.setChatId(chat.getId());
			return "Создан чат №" + chat.getId() + " " + chat.getName() + "\n Выбран чат №" + appData.getChatId() + " Для завершения диалога введите команду $leavechat\n";
		} 
		catch (RuntimeException e) {
			return e.getMessage();
		}
	}
	
	private Collection<Long> getUserIdsFromString(String userIds) {
		ArrayList<Long> idList = new ArrayList<Long>();
	    String[] ids  = userIds.trim().split(" ");
	    
	    try {
			for (String s : ids) {
				idList.add(Long.parseLong(s));
			}
			return idList;
	    }
	    catch (RuntimeException ex){
	    	throw new StringFormatException("Неверный формат строки\n");
	    }
	}


	public Collection<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(Collection<Long> userIds) {
		this.userIds = userIds;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
