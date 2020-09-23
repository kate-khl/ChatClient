package org.khl.chat.command;

public class SignIn extends Command{

	private String login;
	private String password;
	


	public SignIn(CommandType commandType, String login, String password) {
		super(commandType);
		this.login = login;
		this.password = password;
	}



	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
