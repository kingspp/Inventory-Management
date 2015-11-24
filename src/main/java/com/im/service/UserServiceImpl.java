package com.im.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.im.dao.IUserDAO;
import com.im.domain.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO userDao;

	public void insertUser( User user )
	{
		System.out.println("in insertUser service");
		userDao.insertUser(user);

	}

	public void deleteUser()
	{

	}

	public List<User> getAllUsers()
	{
		List<User> list = userDao.getAllUsersDao();
		return list;
	}

}
