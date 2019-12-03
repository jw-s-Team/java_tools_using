package com.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jw.pojo.User;

public interface UserDao {
	public void createUser(User user);

	public User getUserByName(String userName);

	@Select("select * from tb_user order by last_modify_time desc")
	public List<User> getUserList();
}
