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
		System.out.println("in insertUser DAO");
		Session session = factory.openSession();
		session.beginTransaction();
		// implementing it for testing purpose , needs to be changed
		session.save(new User("shreesha", "s@gmail.com", 98869));
		session.getTransaction().commit();
	}

	@Override
	public void deleteUser()
	{

	}

	@Override
	@SuppressWarnings( "unchecked" )
	public List<User> getAllUsersDao( char alphabet )
	{
		System.out.println("inside UserDao");
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where userName like :alphabet");
		query.setParameter("alphabet",alphabet + "%");
		List<User> list = query.list();
		return list;
	}
}
