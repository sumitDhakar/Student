package com.student.exception;

public class UserNotFoundException extends RuntimeException

{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User Not Found ");
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundException(String Message) {
		super(Message);
		// TODO Auto-generated constructor stub
	}


	}



