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
@Table( name = "inventory" )
@NamedNativeQueries( { @NamedNativeQuery( name = "Inventory.getAllInventories", query = "select * from inventory ", resultClass = Inventory.class ),
					   @NamedNativeQuery( name = "Inventory.getFreeInventories", query = "select * from inventory where is_busy=0", resultClass = Inventory.class ),
					   @NamedNativeQuery( name = "Inventory.getInventoryForUser", query = "SELECT * FROM inventory AS i INNER JOIN user_inventory AS u ON i.inventory_id=u.inventory_inventory_id WHERE u.user_user_id= :userId ", resultClass = Inventory.class ),
					   @NamedNativeQuery( name = "Inventory.getInventoryForId", query = "select * from inventory where inventory_id= :inventoryId ", resultClass = Inventory.class )
} )
public class Inventory {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "inventory_id" )
	private Integer inventoryId;

	@Column( name = "inventory_name" )
	private String inventoryName;

	@Column( name = "file_path" )
	private String filePath;

	@Column( name = "price" )
	private Double price;

	@Column( name = "type" )
	private String type;

	@Column( name = "serial_number" )
	private String serialNumber;

	@Column( name = "purchase_date" )
	private String purchaseDate;
	
	@Column(name = "is_busy")
	private Integer isBusy;

	
	
	public Integer getIsBusy()
	{
		return isBusy;
	}

	
	public void setIsBusy( Integer isBusy )
	{
		this.isBusy = isBusy;
	}

	public Integer getInventoryId()
	{
		return inventoryId;
	}

	public void setInventoryId( Integer inventoryId )
	{
		this.inventoryId = inventoryId;
	}

	public String getInventoryName()
	{
		return inventoryName;
	}

	public void setInventoryName( String inventoryName )
	{
		this.inventoryName = inventoryName;
	}

	public String getImagePath()
	{
		return filePath;
	}

	public void setImagePath( String imagePath )
	{
		this.filePath = imagePath;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath( String filePath )
	{
		this.filePath = filePath;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber( String serialNumber )
	{
		this.serialNumber = serialNumber;
	}

	public String getPurchaseDate()
	{
		return purchaseDate;
	}

	public void setPurchaseDate( String purchaseDate )
	{
		this.purchaseDate = purchaseDate;
	}

}
