package com.im.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.im.beans.User;
import com.im.exception.CustomGenericException;
import com.im.service.IUserService;
import com.im.utils.JSONResponse;
import com.im.utils.SaveImage;

@Controller
@RequestMapping( "/rest" )
public class InventoryController {

	@Autowired
	IUserService userService;

	@Autowired
	JSONResponse jsonResponse;

	@RequestMapping( value = "/save", method = RequestMethod.GET )
	public @ResponseBody
	String save()
	{
		System.out.println("here");
		return "success";
	}

	@RequestMapping( value = "/getUsers/{queryString}", method = RequestMethod.GET )
	public @ResponseBody
	List<User> getAllUsers( @PathVariable( "queryString" )
	Character alphabet ) throws Exception
	{
		try
		{
			if( alphabet == null )
			{
				throw new CustomGenericException("Please pass a alphabet");
			}
			else
			{
				List<User> list = userService.getAllUsers(alphabet);
				return list;
			}

		}
		catch( CustomGenericException e )
		{
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping( value = "/insertUser", method = RequestMethod.POST )
	public @ResponseBody
	JSONResponse insertUser( User user, @RequestParam( value = "imageFile", required = false )
	MultipartFile image ) throws Exception
	{
		try
		{
			if( user == null )
			{
				throw new CustomGenericException("Please pass the user details");
			}

			String path = SaveImage.imageSave(image);
			user.setFilePath(path);
			userService.insertUser(user);
			jsonResponse.setMessage("User successfuly saved");
			return jsonResponse;

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