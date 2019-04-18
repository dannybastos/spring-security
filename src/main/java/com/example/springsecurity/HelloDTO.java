package com.example.springsecurity;

/**
 * Created by dannybastos on 17/04/19.
 */
public class HelloDTO {

	private String message;
	
	public HelloDTO() {	}

	public HelloDTO(String message) {
		this();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
