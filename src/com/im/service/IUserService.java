package com.im.service;

import java.util.List;
import com.im.beans.User;

public interface IUserService {

	public void insertUser();

	public void deleteUser();

	public List<User> getAllUsers( char alphabet );

}
