package org.khl.chat.dto;

import java.util.Date;

public class MessageDto {
	
	private Long id;
	private String value;
	private UserDto author;
	private Date date;

	public MessageDto() {}
	
	@Override
	public String toString() {
		String result = this.getDate() + " " + this.getAuthor().getName() + " " + this.getValue() + "\n";
		return result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public UserDto getAuthor() {
		return author;
	}
	public void setAuthor(UserDto author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
