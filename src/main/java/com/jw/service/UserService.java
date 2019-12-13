package com.jw.service;

import java.util.List;

import com.jw.pojo.User;
import com.jw.pojo.VwUserRole;

public interface UserService {
	public User doLogin(String userName, String password);
	
	public void doRegister(String userName,String password);

	public int doValidateAccount(String userName);

	public List<VwUserRole> getUserList();

	public String addOneUser(String userName, String password, String remark, Long roleId,Long classId);

	public Long newOneUser(String userName, String password, String remark);
}
