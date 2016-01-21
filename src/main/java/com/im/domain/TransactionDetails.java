package com.im.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table( name = "transaction_details" )
@NamedNativeQueries( {
		@NamedNativeQuery( name = "TransactionDetails.getTransactions", query = "select * from transaction_details", resultClass = TransactionDetails.class ) })
public class TransactionDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "transaction_id" )
	private Integer transactionId;

	@Column( name = "message" )
	private String message;

	@Column( name = "user_name" )
	private String userName;

	@Column( name = "time" )
	private Long time;

	@Column( name = "project" )
	private String project;

	@Column( name = "inventory_name" )
	private String inventoryName;

	@Column( name = "serial_number" )
	private String serialNumber;

	@Column( name = "flag" )
	private String flag;

	public Integer getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId( Integer transactionId )
	{
		this.transactionId = transactionId;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName( String userName )
	{
		this.userName = userName;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject( String project )
	{
		this.project = project;
	}

	public String getInventoryName()
	{
		return inventoryName;
	}

	public void setInventoryName( String inventoryName )
	{
		this.inventoryName = inventoryName;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag( String flag )
	{
		this.flag = flag;
	}

	public Long getTime()
	{
		return time;
	}

	public void setTime( Long time )
	{
		this.time = time;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber( String serialNumber )
	{
		this.serialNumber = serialNumber;
	}

}
