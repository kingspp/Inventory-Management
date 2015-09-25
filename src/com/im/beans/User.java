package com.im.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int userId;
	private String userName;
	private String emaild;
	private long phoneNumber;

	public User()
	{

	}

	public User( String name )
	{
		userName = name;
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
		return emaild;
	}

	public void setEmaild( String emaild )
	{
		this.emaild = emaild;
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
