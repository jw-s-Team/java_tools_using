package com.jw.service.serviceImpl;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.mapper.UserMapper;
import com.jw.pojo.User;
import com.jw.service.UserService;
import com.jw.utils.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	User user;

	@Override
	public void doRegister(String userName,String password) {
		user.setUserName(userName);
		user.setPassword(MD5Util.string2MD5(password));
		userMapper.createUser(user);
	}
	
	
	@Override
	public int doValidateAccount(String userName) {
		int result=0;
		if(userMapper.getUserByName(userName)!=null){
			result=1;
		}
		return result;
	}
	
	@Override
	public User doLogin(String userName, String password) {
		Subject subject=SecurityUtils.getSubject();//获取当前用主体：如当前用户
		UsernamePasswordToken token=new UsernamePasswordToken(userName, password);//存储当前用户信息
		try {
			subject.login(token);//进入subject的login:调用UserRealm.doGetAuthenticationInfo方法
			User user=userMapper.getUserByName(userName);
			return user;
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return null;
	}


	

	

	

	

}
