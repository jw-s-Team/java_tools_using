package com.jw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.pojo.User;
import com.jw.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getUserList")
	@ResponseBody
    public List<User> getUserList() {
		return userService.getUserList();
	}

}
