package org.khl.chat.command;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Help  extends Command{

	@Autowired
	private Set<Command> cmds;
	@Autowired
	private CommandResult result;
	
	public Help() {
		super(CommandType.HELP, "Help desc");
	}

	@Override
	public CommandResult execute() {

		result.setResultString(cmds.toString());
		return result;
	}

}
