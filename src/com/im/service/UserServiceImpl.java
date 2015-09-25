package com.im.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.im.beans.User;
import com.im.dao.UserDAOImpl;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDAOImpl userDao;

	@Override
	public void insertUser()
	{
		userDao.insertUser();

	}

	@Override
	public void deleteUser()
	{

	}

	@SuppressWarnings( "unused" )
	@Override
	public List<User> getAllUsers()
	{
		System.out.println("userService");
		List<User> list = userDao.getAllUsersDao();
		return null;
	}

}
