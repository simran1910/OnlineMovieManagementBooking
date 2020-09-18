package com.cg.dto;

import java.util.List;

public class ErrorMessage {
	public String message;
	public String code;
	public List<String> messages;
	
	
	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public ErrorMessage(String code, String message) {
		super();
		this.message = message;
		this.code = code;
	}
	
	public ErrorMessage(String code, List<String> messages) {
		super();
		this.messages = messages;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


}
