package com.im.hellocontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.im.beans.User;
import com.im.service.IUserService;

@Controller
@RequestMapping( "/welcome" )
public class HelloController {

	@Autowired
	IUserService userService;

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService( IUserService userService )
	{
		this.userService = userService;
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
	String insertUser()
	{
		userService.insertUser();
		return "success";
	}

}