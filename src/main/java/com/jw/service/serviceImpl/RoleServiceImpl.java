package com.jw.service.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.mapper.RoleMapper;
import com.jw.pojo.Role;
import com.jw.service.RoleService;
 

 
@Service
public class RoleServiceImpl  implements RoleService{
 
    @Autowired RoleMapper roleMapper;
 
    @Override
    public Set<String> listRoles(String userName) {
        List<Role> roles = roleMapper.listRolesByUserName(userName);
        Set<String> result = new HashSet<>();
        for (Role role: roles) {
            result.add(role.getName());
        }
        return result;
    }
}
