package com.im.service;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.utils.JSONResponse;

public interface IInventoryService {

    public JSONResponse insertInventory( Inventory inventory, MultipartFile image ) throws Exception;

    public JSONObject getAllInventories() throws Exception;

    public List<TransactionDetails> getTransactions() throws Exception;

	public JSONObject getFreeInventories() throws Exception;

	public JSONObject getInventoryForUser(Integer userId) throws Exception;

	public JSONResponse addInventoryForUser( Integer inventoryId, Integer userId ) throws Exception;

	public JSONResponse removeInventoryForUser( Integer inventoryId, Integer userId ) throws Exception;
}
