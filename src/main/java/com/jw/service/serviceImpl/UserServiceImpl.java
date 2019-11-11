package com.jw.service.serviceImpl;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.jw.dao.UserDao;
import com.jw.pojo.User;
import com.jw.service.UserService;
import com.mysql.cj.Constants;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public User doLogin(String userName, String password) {
		Subject subject=SecurityUtils.getSubject();//获取当前用主体：如当前用户
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);//存储当前用户信息
		try {
			subject.login(token);//进入subject的login:调用UserRealm.doGetAuthenticationInfo方法
			System.out.println("success");
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	

	

	

}
