package com.im.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int userId;
	private String userName;
	private String emailId;
	private long phoneNumber;

	public User()
	{

	}

	public User( String name, String email, long number )
	{
		userName = name;
		emailId = email;
		phoneNumber = number;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId( int userId )
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName( String userName )
	{
		this.userName = userName;
	}

	public String getEmaild()
	{
		return emailId;
	}

	public void setEmaild( String emaild )
	{
		this.emailId = emaild;
	}

	public long getpNumber()
	{
		return phoneNumber;
	}

	public void setpNumber( long pNumber )
	{
		this.phoneNumber = pNumber;
	}

}
