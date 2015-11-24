package com.im.controller;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.im.domain.User;
import com.im.exception.CustomGenericException;
import com.im.service.IUserService;
import com.im.utils.JSONResponse;
import com.im.utils.SaveImage;

@Controller
@RequestMapping( "/user" )
public class UserController {

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

	@SuppressWarnings( "unchecked" )
	@RequestMapping( value = "/getUsers", method = RequestMethod.GET )
	public @ResponseBody
	JSONObject getAllUsers() throws Exception
	{
		try
		{
			List<User> list = userService.getAllUsers();
			if( list.isEmpty() || list.size() <= 0 )
			{
				throw new CustomGenericException("There are no users registered");
			}
			JSONObject baseObject = null;
			JSONArray userArray = new JSONArray();
			JSONObject user = null;
			JSONObject results = new JSONObject();
			for( int i = 0; i < list.size(); i++ )
			{
				baseObject = new JSONObject();
				baseObject.put("userName", list.get(i).getUserName());
				baseObject.put("userId", list.get(i).getUserId());
				baseObject.put("emailId", list.get(i).getEmailId());
				baseObject.put("bloodGroup", list.get(i).getBloodGroup());
				baseObject.put("project", list.get(i).getProject());
				baseObject.put("gender", list.get(i).getGender());
				baseObject.put("phoneNumber", list.get(i).getPhoneNumber());
				user = new JSONObject();
				user.put("user", baseObject);
				userArray.add(user);
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