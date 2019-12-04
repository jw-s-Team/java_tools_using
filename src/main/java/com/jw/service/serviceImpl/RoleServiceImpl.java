package com.jw.service.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.RoleDao;
import com.jw.pojo.Role;
import com.jw.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<String> getRoles() {
		System.out.println(roleDao.getRoles());
		return roleDao.getRoles();
	}
	

	

	

	

	

}
