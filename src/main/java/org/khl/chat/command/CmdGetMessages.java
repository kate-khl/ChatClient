package org.khl.chat.command;

import java.util.List;
import java.util.ArrayList;

import org.khl.chat.dto.UserDto;

public class CmdGetMessages extends Command {

	@Override
	public String execute() {

		if (appData.validToken())
		{
			try {
				List<UserDto> users = requestService.getUsers(appData.getToken());
				return users.toString();
			} 
			catch (RuntimeException e) {
				return e.getMessage();
			}
		}
		else return "Необходима авторизация";
		
	}
}
