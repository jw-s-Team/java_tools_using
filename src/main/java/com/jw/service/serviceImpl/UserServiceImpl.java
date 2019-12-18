package com.jw.service.serviceImpl;



import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.UserDao;
import com.jw.pojo.User;
import com.jw.pojo.VwUserRole;
import com.jw.service.UserClassService;
import com.jw.service.UserRoleService;
import com.jw.service.UserService;
import com.jw.utils.MD5Util;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	User user;

	@Override
	public void doRegister(String userName,String password) {
		user.setUserName(userName);;
		user.setPassword(MD5Util.string2MD5(password));
		userDao.createUser(user);
	}
	
	
	@Override
	public int doValidateAccount(String userName) {
		int result=0;
		if(userDao.getUserByName(userName)!=null){
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
			User user=userDao.getUserByName(userName);
			return user;
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<VwUserRole> getUserList() {
		System.out.println(userDao.getUserList());
		return userDao.getUserList();
	}
	
	//待定
	public String genarateUserId(){
		return null;
		
	}
	
	//盐生成规则：用户名+
	public String generateSalt(String userName){
		return userName+ new SecureRandomNumberGenerator().nextBytes().toHex();
		
	} 
	
	public String encrypPassword(String salt,String password){
		return MD5Util.string2MD5(salt+password);
		
	}
	
	


	@Override
	public Long newOneUser(String userName, String password, String remark) {
		user.setUserName(userName);
		String salt=generateSalt(userName);
		user.setSalt(salt);
		user.setPassword(encrypPassword(salt, password));
		user.setCreateTime(new Date());
		user.setLastModifyTime(new Date());
		user.setRemark(remark);
		userDao.newOneUser(user);
		return user.getUserId();
	}


	@Autowired
	UserRoleService userRoleService;
	@Autowired
	UserClassService userClassService;
	@Override
	public String addOneUser(String userName, String password, String remark, Long roleId,Long classId) {
		String result="";
		Long userId=newOneUser(userName,password,remark);
		userClassService.newOneUserClass(userId,classId);
		Long insertFlag=userRoleService.newOneUserRole(userId,roleId);
		if(insertFlag!=null){
			result="success";
		}
		return result;
	}


	@Override
	public int delOneUser(Long userId) {
		//删除用户，删除用户班级关联数据，用户角色关联数据
		return userDao.delOneUser(userId);
	}


	


	

	

	

	

}
