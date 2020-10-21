package org.khl.chat.dto;

import java.util.Collection;

public class ChatDto {

	private Long id;
	private String name;
	private UserDto author;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public UserDto getAuthor() {
		return author;
	}

	public void setAuthor(UserDto author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		String result = "Chat №" + this.id + " " + this.name;
		return result;
	}
	
}
