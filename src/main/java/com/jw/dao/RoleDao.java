package com.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jw.pojo.Role;

public interface RoleDao {
	
	public List<String> getRoles();

}
