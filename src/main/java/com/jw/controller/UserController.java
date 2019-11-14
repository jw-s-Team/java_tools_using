package com.jw.controller;

import com.jw.pojo.User;
import com.jw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
    public String login(String userName, String password,HttpServletRequest request) {
		User user=userService.doLogin(userName, password);
		if(user==null){ 
			request.setAttribute("error", "用户名或密码错误");
			return "error";
		}
		return "welcome";
	}
	
	@RequestMapping(value="/register")
    public String register(String userName, String password,HttpServletRequest request) {
		userService.doRegister(userName, password);
		return "welcome";
	}
	
	@RequestMapping(value="/validateAccount")
	@ResponseBody
    public int validateAccount(String userName) {
		return userService.doValidateAccount(userName);
	}
	
		
}
