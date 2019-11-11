package com.jw.mapper;

import com.jw.pojo.User;

public interface UserMapper {
	public User createUser(User user);

	public User getUserByName(String userName);
	

}
