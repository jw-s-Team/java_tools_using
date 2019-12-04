package com.jw.dao;

import com.jw.pojo.User;
import com.jw.pojo.VwUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
	public void createUser(User user);

	public User getUserByName(String userName);

	@Select("select * from tb_user order by last_modify_time desc")
	public List<User> getUserList();

	List<VwUserRole> queryUserRole();
}
