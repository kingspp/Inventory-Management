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

	@Column( name = "time" )
	private Long time;

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

	public Long getTime()
	{
		return time;
	}

	public void setTime( Long time )
	{
		this.time = time;
	}

}
