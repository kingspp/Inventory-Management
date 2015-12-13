package com.im.service;

import java.util.List;
import org.json.simple.JSONObject;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.utils.JSONResponse;

public interface IInventoryService {

    public JSONResponse insertInventory( Inventory inventory ) throws Exception;

    public JSONObject getAllInventories() throws Exception;

    public List<TransactionDetails> getTransactions() throws Exception;
}
