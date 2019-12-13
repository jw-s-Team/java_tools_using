package com.jw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.pojo.VwClassGrade;
import com.jw.service.ClassService;

@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired
	ClassService classService;
	
	@RequestMapping(value="/getClassList")
	@ResponseBody
	public List<VwClassGrade> getClassList(){		
		return classService.getClassList();
	}
	
	@RequestMapping(value="/getUserClass")
	@ResponseBody
	public List<String>getUserClass(Long gradeId){
		return classService.getUserClass(gradeId);
	}

}
