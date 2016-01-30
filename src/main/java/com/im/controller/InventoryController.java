package com.im.controller;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.im.domain.Inventory;
import com.im.domain.TransactionDetails;
import com.im.exception.CustomGenericException;
import com.im.service.IInventoryService;
import com.im.utils.JSONResponse;
import com.im.utils.StringConstants;

@RestController
@RequestMapping( "/inventory" )
public class InventoryController {

    @Autowired
    IInventoryService iService;

    @RequestMapping( value = "/insertInventory", method = RequestMethod.POST )
    public JSONResponse insertInventory( @RequestPart(value ="data")
    Inventory inventory  ,@RequestPart(value = "image", required = false) MultipartFile image) throws Exception
    {
        try
        {
            if( inventory == null )
            {
                throw new CustomGenericException(StringConstants.PASS_INVENTORY);
            }
            return iService.insertInventory(inventory,image);
        }
        catch( Exception e )
        {
            e.printStackTrace();
            throw e;
        }

    }

    @RequestMapping( value = "/getInventory", method = RequestMethod.GET )
    public JSONObject getInventory() throws Exception
    {
        try
        {
            return iService.getAllInventories();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping( value = "/getFreeInventory", method = RequestMethod.GET )
    public JSONObject getFreeInventory() throws Exception
    {
        try
        {
            return iService.getFreeInventories();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            throw e;
        }
    }
    @RequestMapping( value = "/getTransactions", method = RequestMethod.GET )
    public List<TransactionDetails> getTransactions() throws Exception
    {
        try
        {
            return iService.getTransactions();
        }
        catch( Exception e )
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    @RequestMapping( value = "/getInventoryForuser/{userId}", method = RequestMethod.GET )
    public JSONObject getInventoryForUser(@PathVariable Integer userId) throws Exception
    {
    	try
    	{
    		return iService.getInventoryForUser(userId);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    @RequestMapping( value = "/addInventoryForUser", method = RequestMethod.GET  )
    public JSONResponse addInventoryForUser(@RequestParam("iid") Integer inventoryId,@RequestParam("uid") Integer userId) throws Exception
    {
    	try{
    		return iService.addInventoryForUser(inventoryId,userId);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    @RequestMapping( value = "/removeInventoryForUser", method = RequestMethod.GET  )
    public JSONResponse removeInventoryForUser(@RequestParam("iid") Integer inventoryId,@RequestParam("uid") Integer userId) throws Exception
    {
    	try{
    		return iService.removeInventoryForUser(inventoryId,userId);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw e;
    	}
    }

    
    
    @ExceptionHandler( CustomGenericException.class )
    public @ResponseBody
    ResponseEntity<JSONResponse> handleCustomException( CustomGenericException e )
    {
        return new ResponseEntity<JSONResponse>(new JSONResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
