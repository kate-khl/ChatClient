package org.khl.chat.command;

import org.springframework.stereotype.Component;

@Component
public class CommandResult {

	private String resultString;

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	
}
