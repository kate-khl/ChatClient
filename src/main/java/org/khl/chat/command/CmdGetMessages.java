package org.khl.chat.command;

import java.util.List;
import java.util.ArrayList;

import org.khl.chat.dto.MessageDto;
import org.khl.chat.dto.UserDto;

public class CmdGetMessages extends Command {

	@Override
	public String execute() {

		if (appData.validToken())
		{
			try {
				if (appData.getChatId() != null)
				{
					List<MessageDto> msgs = requestService.getMessages(appData.getToken(), appData.getChatId());
					return msgs.toString();
				}
				else return "Чат не выбран";
			} 
			catch (RuntimeException e) {
				return e.getMessage();
			}
		}
		else return "Необходима авторизация";
	}
}
