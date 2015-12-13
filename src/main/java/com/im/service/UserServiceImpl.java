package com.im.service;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.im.dao.CommonsDao;
import com.im.dao.IUserDAO;
import com.im.domain.TransactionDetails;
import com.im.domain.User;
import com.im.utils.JSONResponse;
import com.im.utils.SaveImage;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDao;

    @Autowired
    CommonsDao commonsDao;

    @Autowired
    JSONResponse jsonResponse;

    TransactionDetails transactionDetails = new TransactionDetails();

    public void insertUser( User user, MultipartFile image )
    {
        try
        {
            String path = SaveImage.imageSave(image, "user");
            user.setFilePath(path);
            commonsDao.persistObject(user);
            transactionDetails.setMessage(user.getUserName() + " has been added !!");
            commonsDao.persistObject(transactionDetails);

        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    public void deleteUser()
    {

    }

    @SuppressWarnings( "unchecked" )
    public JSONObject getAllUsers()
    {
        List<User> list = userDao.getAllUsersDao();

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
            // baseObject.put("set", list.get(i).getInventory());
            user = new JSONObject();
            user.put("user", baseObject);
            userArray.add(user);
        }

        results.put("results", userArray);
        System.out.println(results);
        return results;

    }

}
