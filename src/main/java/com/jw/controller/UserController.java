package com.jw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jw.pojo.User;
import com.jw.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
    public String login(String userName, String password,HttpServletRequest request) {
		User user=userService.doLogin(userName,password);
		if(user==null){
			request.setAttribute("error", "用户名或密码错误");
			return "index";
		}
		return "welcome";
	}

		
}