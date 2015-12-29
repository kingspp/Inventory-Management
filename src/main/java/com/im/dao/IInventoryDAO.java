package com.im.dao;

import java.util.List;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;

public interface IInventoryDAO {

    public List<Inventory> getAllInventories();

    public List<TransactionDetails> getTransactions();

	public List<Inventory> getFreeInventories();

	public List<Inventory> getInventoryForUser( Integer userId );

	public List<Inventory> getInventoryForId( Integer inventoryId );

}
