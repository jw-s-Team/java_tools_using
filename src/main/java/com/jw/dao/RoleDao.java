package com.jw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jw.pojo.Role;

public interface RoleDao {
	
	@Select("select * from tb_role order by last_modify_time desc")
	public List<Role> getRoleList();

}
