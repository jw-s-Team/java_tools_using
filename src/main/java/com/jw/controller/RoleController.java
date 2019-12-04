package com.jw.controller;

import com.jw.pojo.Role;
import com.jw.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="/getRoleList")
	@ResponseBody
    public List<Role> getRoleList() {

		return roleService.getRoleList();

	}

}
