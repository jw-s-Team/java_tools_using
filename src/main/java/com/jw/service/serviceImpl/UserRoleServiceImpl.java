package com.jw.service.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.UserRoleDao;
import com.jw.pojo.UserRole;
import com.jw.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleDao userRoleDao;
	@Autowired
	UserRole userRole;
	
	

	@Override
	public Long newOneUserRole(Long userId, Long roleId) {
		userRole.setUserId(userId);
		userRole.setRoleId(roleId);
		userRole.setCreateTime(new Date());
		userRole.setLastModifyTime(new Date());
		return userRoleDao.newOneUserRole(userRole);
	}

}
