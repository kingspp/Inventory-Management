package com.im.dao;

import java.util.List;
import com.im.beans.User;

public interface IUserDAO {

	public void insertUser();

	public void deleteUser();

	public List<User> getAllUsersDao( char alphabet );

}
