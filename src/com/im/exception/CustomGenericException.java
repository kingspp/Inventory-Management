package com.im.exception;

public class CustomGenericException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public CustomGenericException( String msg )
	{
		message = msg;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

}
