package com.im.controller;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
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

    @RequestMapping( value = "/insertUser", method = RequestMethod.POST )
    public @ResponseBody
    JSONResponse insertUser(
            @Valid @RequestPart(value="data") User user
            ,@RequestPart(value = "image", required = false) MultipartFile image
    ) throws Exception {
    
        try
        {
            if( user == null )
            {
                throw new CustomGenericException("Please pass the user details");
            }

            userService.insertUser(user, image);
        	//SaveImage.imageSave(image, "abcd");
            jsonResponse.setMessage("success");
            return jsonResponse;

        }
        catch( Exception e )
        {
            e.printStackTrace();
            throw e;
        }

    }

    @RequestMapping( value = "/getUsers", method = RequestMethod.GET )
    public @ResponseBody
    JSONObject getAllUsers() throws Exception
    {
        try
        {
            JSONObject o = userService.getAllUsers();
            if( o.isEmpty() || o.size() <= 0 )
            {
                throw new CustomGenericException("There are no users registered");
            }
            return o;

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
    
    
    
    //////
    
    
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public @ResponseBody JSONResponse save(
            @Valid @RequestPart(value="data") User user
            ,@RequestPart(value = "image", required = false) MultipartFile image
    ) throws Exception {
        try {
        	System.out.println("In try Block");
        	System.out.println("User:"+ user.getUserName());
        	System.out.println("Image"+ image.getSize());
        	jsonResponse.setMessage("success");
            return jsonResponse;

            
        }  catch(Exception e) {
        	jsonResponse.setMessage("fail");
            return jsonResponse;
        }
    }

}