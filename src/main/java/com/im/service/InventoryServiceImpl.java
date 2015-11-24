package com.im.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.im.dao.IInventoryDAO;
import com.im.domain.Inventory;
import com.im.exception.CustomGenericException;
import com.im.utils.JSONResponse;
import com.im.utils.StringConstants;

@Service
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	IInventoryDAO iDao;

	@Override
	public JSONResponse insertInventory( Inventory inventory ) throws Exception
	{
		try
		{
			if( inventory == null )
			{
				throw new CustomGenericException(StringConstants.PASS_INVENTORY);
			}
			return iDao.insertInventory(inventory);

		}

		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public JSONObject getAllInventories() throws Exception
	{
		try
		{
			return iDao.getAllInventories();

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}
}
