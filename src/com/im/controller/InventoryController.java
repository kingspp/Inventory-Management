package com.im.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.im.beans.User;
import com.im.service.IUserService;
import com.im.utils.SaveImage;

@Controller
@RequestMapping( "/welcome" )
public class InventoryController {

	@Autowired
	IUserService userService;

	@RequestMapping( value = "/save", method = RequestMethod.GET )
	public @ResponseBody
	String save()
	{
		System.out.println("here");
		return "success";
	}

	@RequestMapping( value = "/hello/{queryString}", method = RequestMethod.GET )
	public @ResponseBody
	List<User> getAllUsers( @PathVariable( "queryString" )
	char alphabet )
	{
		List<User> list = userService.getAllUsers(alphabet);
		return list;
	}

	@RequestMapping( value = "/insert", method = RequestMethod.POST )
	public @ResponseBody
	String insertUser( @RequestParam( "userName" )
	String uname, @RequestParam( value = "imageFile", required = false )
	MultipartFile image )
	{
		System.out.println("inside insert method");
		User user = new User();
		String path = SaveImage.imageSave(image);
		user.setUserName(uname);
		user.setFilePath(path);
		// System.out.println(path);
		userService.insertUser(user);

		return "success";
	}

}