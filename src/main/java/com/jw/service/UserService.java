package com.jw.service;

import com.jw.pojo.User;

public interface UserService {
	public User doLogin(String userName, String password);

	public User getUserByName(String userName);
}
