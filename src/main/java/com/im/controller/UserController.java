package com.im.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping( value = "/insertUser", method = RequestMethod.POST )
    public @ResponseBody
    JSONResponse insertUser( @RequestParam( value = "imageFile", required = false )
    MultipartFile image ) throws Exception
    {
    	System.err.println("made");
        try
        {
           /* if( user == null )
            {
                throw new CustomGenericException("Please pass the user details");
            }

            userService.insertUser(user, image);*/
        	SaveImage.imageSave(image, "/abcd");
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

}