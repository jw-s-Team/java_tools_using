package com.jw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.mapper.UserMapper;
import com.jw.pojo.User;
import com.jw.service.UserService;
 

 
@Service
public class UserServiceImpl  implements UserService{
 
    @Autowired UserMapper userMapper;
     
    @Override
    public String getPassword(String name) {
        // TODO Auto-generated method stub
        User u  = userMapper.getByName(name);
        if(null==u)
            return null;
        return u.getPassword();
    }
 
}
