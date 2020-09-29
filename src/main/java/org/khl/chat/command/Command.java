package org.khl.chat.command;

import org.khl.chat.exception.InvalidCommandParamException;
import org.springframework.web.client.RestTemplate;

public abstract class Command {

	public static String description = "$help - справка; \n"
									+ "$signup -name yourname -email your@email.com -password yourpassword - регистрация нового пользователя; \n"
									+ "$singin -email your@email.com -password yourpassword - вход зарегистрированного пользователя\n";
	RestTemplate restTemplate;
	
	public Command() {
		super();
	}

	public Command(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	public abstract String  execute(RestTemplate restTemplate);

	
	protected String getParamValueFromInputString(String inputStr, String paramName) {
		
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
