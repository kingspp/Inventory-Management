package com.im.dao;

import java.util.List;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;

public interface IInventoryDAO {

    public List<Inventory> getAllInventories() throws Exception;

    public List<TransactionDetails> getTransactions();

}
