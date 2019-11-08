package com.jw.dao;

import com.jw.pojo.User;

public interface UserDao {
	public User createUser(User user);

	public User getUserByName(String userName);
	

}
