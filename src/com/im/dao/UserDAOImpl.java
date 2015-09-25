package com.im.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.im.beans.User;

@Component
public class UserDAOImpl implements IUserDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public void insertUser()
	{
		System.out.println("Method hit !!!");
	}

	@Override
	public void deleteUser()
	{

	}

	@Override
	@SuppressWarnings( "unchecked" )
	public List<User> getAllUsersDao()
	{
		System.out.println("userServiceDao");
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}
}
