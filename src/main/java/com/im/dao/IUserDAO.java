package com.im.dao;

import java.util.List;
import com.im.domain.User;

public interface IUserDAO {

    public void deleteUser(User user);

    public List<User> getAllUsersDao();

	public List<User> getUserForId( Integer userId );

}
