package com.im.dao;

import java.util.List;
import com.im.domain.User;

public interface IUserDAO {

	public void insertUser( User user );

	public void deleteUser();

	public List<User> getAllUsersDao();

}
