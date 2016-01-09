package com.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String test(Model map)
	{
		//ModelAndView m = new ModelAndView("index");
		 return "index";
	}

}
