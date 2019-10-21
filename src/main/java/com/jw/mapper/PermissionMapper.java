package com.jw.mapper;

import java.util.List;

import com.jw.pojo.Permission;

 
public interface PermissionMapper {
    public List<Permission> listPermissionsByUserName(String userName);
     
}
