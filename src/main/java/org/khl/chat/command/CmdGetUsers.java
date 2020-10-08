package org.khl.chat.command;

import java.util.List;
import java.util.ArrayList;

import org.khl.chat.dto.UserDto;

public class CmdGetUsers extends Command {

	@Override
	public String execute() {

		List<UserDto> users = requestService.getUsers(appData.getToken());
		return users.toString();
	}

}
