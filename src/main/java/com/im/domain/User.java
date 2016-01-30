package com.im.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "user" )
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedNativeQueries( { @NamedNativeQuery( name = "User.getUsers", query = "select * from user ", resultClass = User.class ),
	@NamedNativeQuery( name = "User.getUserForId", query = "select * from user where user_id= :userId", resultClass = User.class )


} )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "user_id" )
    private Integer userId;

    @Column( name = "user_name" )
    private String userName;

    @Column( name = "gender" )
    private String gender;

    @Column( name = "doj" )
    private String dateOfJoining;

    @Column( name = "blood_group" )
    private String bloodGroup;

    @Column( name = "email_id" )
    private String emailId;

    @Column( name = "phone_number" )
    private String phoneNumber;

    @Column( name = "file_path" )
    private String filePath;

    @Column( name = "project" )
    private String project;
    
 
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<Inventory> inventory;
    
   

	public Integer getUserId()
    {
        return userId;
    }

    public void setUserId( Integer userId )
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

    public String getGender()
    {
        return gender;
    }

    public void setGender( String gender )
    {
        this.gender = gender;
    }

    public String getDateOfJoining()
    {
        return dateOfJoining;
    }

    public void setDateOfJoining( String dateOfJoining )
    {
        this.dateOfJoining = dateOfJoining;
    }

    public String getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBloodGroup( String bloodGroup )
    {
        this.bloodGroup = bloodGroup;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId( String emailId )
    {
        this.emailId = emailId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath( String filePath )
    {
        this.filePath = filePath;
    }

    public String getProject()
    {
        return project;
    }

    public void setProject( String project )
    {
        this.project = project;
    }

    public Set<Inventory> getInventory()
    {
        return inventory;
    }

    public void setInventory( Set<Inventory> inventory )
    {
        this.inventory = inventory;
    }

	


}
