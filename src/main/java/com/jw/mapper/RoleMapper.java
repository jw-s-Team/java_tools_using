package com.jw.mapper;

import java.util.List;

import com.jw.pojo.Role;
 
public interface RoleMapper {
    public List<Role> listRolesByUserName(String userName);
     
}
