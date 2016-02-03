package com.im.service;

import java.util.Date;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.im.dao.CommonsDao;
import com.im.dao.IInventoryDAO;
import com.im.dao.IUserDAO;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.domain.User;
import com.im.exception.CustomGenericException;
import com.im.utils.JSONResponse;
import com.im.utils.SaveImage;
import com.im.utils.StringConstants;

@Service
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	IInventoryDAO iDao;

	@Autowired
	IUserDAO uDao;

	@Autowired
	CommonsDao commonsDao;

	@Autowired
	JSONResponse jsonResponse;

	TransactionDetails transactionDetails = new TransactionDetails();

	@Override
	public JSONResponse insertInventory( Inventory inventory,MultipartFile image ) throws Exception
	{
		try
		{
			if( inventory == null )
			{
				throw new CustomGenericException(StringConstants.PASS_INVENTORY);
			}
			String path = SaveImage.imageSave(image, "inventory");
			inventory.setFilePath(path);
			inventory.setIsBusy(0);
			transactionDetails.setMessage(inventory.getInventoryName()+"-"+inventory.getSerialNumber()+" has been added to the inventory section ");
			transactionDetails.setTime(new Date().getTime());
			commonsDao.persistObject(inventory);
			commonsDao.persistObject(transactionDetails);
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
	public JSONObject getAllInventories() throws Exception
	{
		try
		{
			List<Inventory> list = iDao.getAllInventories();
			if( list.isEmpty() || list.size() < 0 )
			{
				throw new CustomGenericException("There are no inventories to be displayed");
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
			return results;

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings( "unchecked" )
	public JSONObject getFreeInventories() throws Exception
	{
		try
		{
			List<Inventory> list = iDao.getFreeInventories();
			if( list.isEmpty() || list.size() < 0 )
			{
				throw new CustomGenericException("All the inventories are busy.Please come back later!");
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
			return results;

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<TransactionDetails> getTransactions() throws Exception
	{
		try
		{
			List<TransactionDetails> list = iDao.getTransactions();
			if( list.isEmpty() || list.size() < 0 )
			{
				throw new CustomGenericException("There are no transactions to be displayed");
			}
			return list;

		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings( "unchecked" )
	public JSONObject getInventoryForUser( Integer userId ) throws Exception
	{
		try
		{
			List<Inventory> list = iDao.getInventoryForUser(userId);
			if( list.isEmpty() || list.size() < 0 )
			{
				throw new CustomGenericException("No inventories for this user");
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
			return results;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public JSONResponse addInventoryForUser( Integer inventoryId, Integer userId ) throws Exception
	{

		// first check for inventory in inventory table , if exists , make
		// is_busy as 1 n persist it back
		// then make a entry in the mapping table
		try
		{
			List<Inventory> listI = iDao.getInventoryForId(inventoryId);
			if( listI.size() <= 0 )
			{
				throw new CustomGenericException("There is no inventory for the passed id");
			}
			List<User> listU = uDao.getUserForId(userId);
			if( listI.size() <= 0 )
			{
				throw new CustomGenericException("There is no user for the passed id");
			}

			listI.get(0).setIsBusy(1);
			listU.get(0).getInventory().add(listI.get(0));
			commonsDao.persistObject(listI.get(0));
			commonsDao.persistObject(listU.get(0));
			transactionDetails.setMessage(listI.get(0).getInventoryName() + " has been assigned to "
					+ listU.get(0).getUserName() + " of " + listU.get(0).getProject() );
			transactionDetails.setTime(new Date().getTime());
			// using 'merge()' here as 'persist()' is making this entity to get
			// detached for an exception
			commonsDao.mergeObject(transactionDetails);
			jsonResponse.setMessage(StringConstants.INVENTORY_ASSIGN_SUCCESSFULL);
			return jsonResponse;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public JSONResponse removeInventoryForUser( Integer inventoryId, Integer userId ) throws Exception
	{
		try
		{
			List<Inventory> listI = iDao.getInventoryForId(inventoryId);
			if( listI.size() <= 0 )
			{
				throw new CustomGenericException("There is no inventory for the passed id");
			}
			List<User> listU = uDao.getUserForId(userId);
			if( listI.size() <= 0 )
			{
				throw new CustomGenericException("There is no user for the passed id");
			}
			// add a validation , a query to check if the combination of passed
			// user id and inventory id is present in the db ,
			// if not present throw an exception
			listI.get(0).setIsBusy(1);
			listU.get(0).getInventory().remove(listI.get(0));
			commonsDao.persistObject(listI.get(0));
			commonsDao.persistObject(listU.get(0));
			
			transactionDetails.setMessage(listU.get(0).getUserName() + " from " + listU.get(0).getProject()
					+ " project has returned the " + listI.get(0).getInventoryName() );
			// using 'merge()' here as 'persist()' is making this entity to get
			// detached for an exception
			commonsDao.mergeObject(transactionDetails);
			jsonResponse.setMessage(StringConstants.INVENTORY_REMOVAL_SUCCESSFULL);
			return jsonResponse;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			throw e;
		}
	}

}
