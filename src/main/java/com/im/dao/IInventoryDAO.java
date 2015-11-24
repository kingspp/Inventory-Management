package com.im.dao;

import org.json.simple.JSONObject;
import com.im.domain.Inventory;
import com.im.utils.JSONResponse;

public interface IInventoryDAO {

	public JSONResponse insertInventory( Inventory inventory ) throws Exception;

	public JSONObject getAllInventories() throws Exception;

}
