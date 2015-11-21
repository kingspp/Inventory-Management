package com.im.utils;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class JSONResponse implements Serializable {

	public JSONResponse( String message )
	{
		this.message = message;
	}

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage()
	{
		return message;
	}

	public JSONResponse()
	{

	}

	public void setMessage( String message )
	{
		this.message = message;
	}

}
