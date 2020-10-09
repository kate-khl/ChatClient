package org.khl.chat.command;

import java.util.Scanner;

import org.khl.chat.AppData;
import org.khl.chat.RequestService;
import org.khl.chat.exception.InvalidCommandParamException;

public abstract class Command {

	public static String description = "*** Информация ***\n"
									+ "$help - справка; \n"
									+ "$signup - регистрация нового пользователя; \n"
									+ "$singin - вход зарегистрированного пользователя\n"
									+ "$getusers - получить список всех пользователей"
									+ "$createchat - ";
	
	protected Scanner console;
	
	protected RequestService requestService;
	protected AppData appData;
	
	public Command() {
		super();
	}
	public Command(AppData appData) {
		super();
		this.appData = appData;
	}

	public abstract String execute() throws IllegalStateException;

	public RequestService getReqService() {
		return requestService;
	}
	
	void setReqService(RequestService reqService) {
		this.requestService = reqService;
	}
	
	public AppData getAppData() {
		return appData;
	}

	public void setAppData(AppData appData) {
		this.appData = appData;
	}

	public Scanner getConsole() {
		return console;
	}
	public void setConsole(Scanner console) {
		this.console = console;
	}
	protected String getParamValueFromInputString(String paramName, String inputStr) {
		
		int loginBeginIdx = 0;
		int loginEndIdx = 0;
		
		if (inputStr.indexOf("-" + paramName + " ") != -1)
		{
			loginBeginIdx = inputStr.indexOf("-" + paramName + " ") + ("-" + paramName + " ").length();
		
			if (inputStr.indexOf(" ", loginBeginIdx) != -1) 
				loginEndIdx = inputStr.indexOf(" ", loginBeginIdx);
			else 
				loginEndIdx = inputStr.length();	
		}
		
		if (loginEndIdx - loginBeginIdx > 1)
		{
			char[] result = new char[loginEndIdx - loginBeginIdx];
			inputStr.getChars(loginBeginIdx, loginEndIdx, result, 0);
			
			StringBuilder strResult = new StringBuilder(result.length);
			for (Character c : result)
				strResult.append(c.charValue());
			
			return strResult.toString();
		}
		else 
			 throw new InvalidCommandParamException("Field value error");
	}

	
	
}
