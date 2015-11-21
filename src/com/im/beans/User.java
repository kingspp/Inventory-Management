package com.im.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "user" )
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "user_id" )
	private int userId;
	@Column( name = "user_name" )
	private String userName;
	@Column( name = "email_id" )
	private String emailId;
	@Column( name = "phone_number" )
	private long phoneNumber;
	@Column( name = "file_path" )
	private String filePath;

	public User()
	{

	}

	public User( String name, String email, long number, String path )
	{
		userName = name;
		emailId = email;
		phoneNumber = number;
		filePath = path;

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

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath( String filePath )
	{
		this.filePath = filePath;
	}

	/*
	 * public MultipartFile getImage()
	 * {
	 * return image;
	 * }
	 * public void setImage( MultipartFile image )
	 * {
	 * this.image = image;
	 * }
	 */
}
