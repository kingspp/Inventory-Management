package com.im.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.im.beans.User;
import com.im.dao.IUserDAO;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO userDao;

	@Override
	public void insertUser( User user )
	{
		System.out.println("in insertUser service");
		userDao.insertUser(user);

	}

	@Override
	public void deleteUser()
	{

	}

	@Override
	public List<User> getAllUsers( char alphabet )
	{
		List<User> list = userDao.getAllUsersDao(alphabet);
		return list;
	}

}
