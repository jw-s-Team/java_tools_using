package com.jw.dao;

import com.jw.pojo.UserRole;

public interface UserRoleDao {
	public Long newOneUserRole(UserRole userRole);

	public void delOneUserRole(Long userRoleId);
}
