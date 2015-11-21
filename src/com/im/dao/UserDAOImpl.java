package com.im.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.im.beans.User;
import com.im.utils.CustomEntityManager;

@Repository
@Transactional
public class UserDAOImpl extends CustomEntityManager implements IUserDAO {

	Query query;

	@Override
	public void insertUser( User user )
	{
		getEntityManager().persist(user);
		// implementing it for testing purpose , needs to be changed
		// session.save(new User("shreesha", "s@gmail.com", 98869,
		// "here sits the path"));
	}

	@Override
	public void deleteUser()
	{

	}

	@Override
	@SuppressWarnings( "unchecked" )
	public List<User> getAllUsersDao( char alphabet )
	{
		query = getEntityManager().createNativeQuery("select * from user where user_name like :alphabet", User.class);
		query.setParameter("alphabet", alphabet + "%");
		List<User> list = query.getResultList();
		return list;
	}
}
