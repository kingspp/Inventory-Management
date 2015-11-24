package com.im.service;

import org.json.simple.JSONObject;
import com.im.domain.Inventory;
import com.im.utils.JSONResponse;

public interface IInventoryService {

	public JSONResponse insertInventory( Inventory inventory ) throws Exception;

	public JSONObject getAllInventories() throws Exception;
}
