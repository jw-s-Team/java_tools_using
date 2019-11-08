package com.jw.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jw.pojo.User;
import com.jw.service.UserService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;

	//获取授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	//获取身份验证信息--登录时候执行
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String) token.getPrincipal();//得到用户名
		User user=userService.getUserByName(userName);
		if(user!=null){
			return new SimpleAuthenticationInfo(userName, user.getPassword(),null,getName());
		}
		return null;
	}

}
