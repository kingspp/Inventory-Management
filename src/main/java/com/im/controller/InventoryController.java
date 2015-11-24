package com.im.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.im.domain.Inventory;
import com.im.exception.CustomGenericException;
import com.im.service.IInventoryService;
import com.im.utils.JSONResponse;
import com.im.utils.StringConstants;

@RestController
@RequestMapping( "/inventory" )
public class InventoryController {

	@Autowired
	IInventoryService iservice;

	@RequestMapping( value = "/insertInventory", method = RequestMethod.POST )
	public JSONResponse insertInventory( Inventory inventory ) throws Exception
	{
		try
		{
			if( inventory == null )
			{
				throw new CustomGenericException(StringConstants.PASS_INVENTORY);
			}
			return iservice.insertInventory(inventory);
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
			return iservice.getAllInventories();
		}

		catch( Exception e )
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
