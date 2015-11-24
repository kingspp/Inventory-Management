package com.im.dao;

import java.util.List;
import javax.persistence.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.im.domain.Inventory;
import com.im.exception.CustomGenericException;
import com.im.utils.CustomEntityManager;
import com.im.utils.JSONResponse;
import com.im.utils.StringConstants;

@Repository
@Transactional
public class InventoryDAOImpl extends CustomEntityManager implements IInventoryDAO {

	Query query = null;

	@Autowired
	JSONResponse jsonResponse;

	@Override
	public JSONResponse insertInventory( Inventory inventory ) throws Exception
	{

		try
		{
			if( inventory == null )
			{
				throw new CustomGenericException(StringConstants.PASS_INVENTORY);
			}
			getEntityManager().persist(inventory);
			jsonResponse.setMessage(StringConstants.INVENTORY_SAVE_SUCCESSFULL);
			return jsonResponse;

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public JSONObject getAllInventories() throws Exception
	{
		try
		{
			query = getEntityManager().createNamedQuery("Inventory.getInventories");
			List<Inventory> list = query.getResultList();
			if( list.isEmpty() || list.size() <= 0 )
			{
				throw new CustomGenericException(StringConstants.NO_INVENTORY);
			}
			JSONObject baseObject = null;
			JSONArray userArray = new JSONArray();
			JSONObject inventory = null;
			JSONObject results = new JSONObject();
			for( int i = 0; i < list.size(); i++ )
			{
				baseObject = new JSONObject();
				baseObject.put("inventoryName", list.get(i).getInventoryName());
				baseObject.put("filePath", list.get(i).getFilePath());
				baseObject.put("price", list.get(i).getPrice());
				baseObject.put("type", list.get(i).getType());
				baseObject.put("serialNumber", list.get(i).getSerialNumber());
				baseObject.put("purchaseDate", list.get(i).getPurchaseDate());
				inventory = new JSONObject();
				inventory.put("inventory", baseObject);
				userArray.add(inventory);
			}
			results.put("results", userArray);
			System.out.println(results);
			return results;
		}

		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}
}
