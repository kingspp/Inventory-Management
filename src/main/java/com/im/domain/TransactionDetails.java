package com.im.domain;

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
@NamedNativeQueries( { @NamedNativeQuery( name = "TransactionDetails.getTransactions", query = "select * from transaction_details", resultClass = TransactionDetails.class ) } )
public class TransactionDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer transactionId;

    @Column( name = "message" )
    private String message;

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

}
