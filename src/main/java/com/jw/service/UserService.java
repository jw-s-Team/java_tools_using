package com.jw.service;

import com.jw.pojo.User;

public interface UserService {
	public User doLogin(String userName, String password);
	
	public void doRegister(String userName,String password);

	public Integer doValidateAccount(String userName);
}
