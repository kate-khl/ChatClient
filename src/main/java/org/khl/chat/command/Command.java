package org.khl.chat.command;

import org.springframework.web.client.RestTemplate;

public abstract class Command {

//	private CommandType commandType;
	String descriprtion;
	RestTemplate restTemplate;
	
	public Command(String descriprtion) {
		super();
		this.descriprtion = descriprtion;
	}

	public Command(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	public abstract String  execute(RestTemplate restTemplate);

	public String getDescriprtion() {
		return descriprtion;
	}

	public void setDescriprtion(String descriprtion) {
		this.descriprtion = descriprtion;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n" + this.getClass().getSimpleName() + ": " + this.getDescriprtion() ;
	}
}
