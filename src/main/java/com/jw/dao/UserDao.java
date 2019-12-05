package com.jw.dao;

import com.jw.pojo.User;
import com.jw.pojo.VwUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
	public void createUser(User user);
	
	public void newOneUser(User user);

	public User getUserByName(String userName);

	public List<VwUserRole> getUserList();
	
	public User getUserById(Long userId);
}
