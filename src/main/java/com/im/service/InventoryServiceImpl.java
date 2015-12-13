package com.im.service;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.im.dao.CommonsDao;
import com.im.dao.IInventoryDAO;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.exception.CustomGenericException;
import com.im.utils.JSONResponse;
import com.im.utils.StringConstants;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    IInventoryDAO iDao;

    @Autowired
    CommonsDao commonsDao;

    @Autowired
    JSONResponse jsonResponse;

    TransactionDetails transactionDetails = new TransactionDetails();

    @Override
    public JSONResponse insertInventory( Inventory inventory ) throws Exception
    {
        try
        {
            if( inventory == null )
            {
                throw new CustomGenericException(StringConstants.PASS_INVENTORY);
            }
            transactionDetails.setMessage(inventory.getInventoryName() + " has been added !!");
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
}
