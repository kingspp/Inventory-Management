package com.im.service;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import com.im.domain.User;

public interface IUserService {

    public void insertUser( User user, MultipartFile image );

    public void deleteUser();

    public JSONObject getAllUsers();

}
