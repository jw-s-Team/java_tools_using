package com.jw.service;

import java.util.List;

import com.jw.pojo.User;

public interface UserService {
	public User doLogin(String userName, String password);
	
	public void doRegister(String userName,String password);

	public int doValidateAccount(String userName);

	public List<User> getUserList();
}
