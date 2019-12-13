package com.jw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.pojo.Grade;
import com.jw.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	GradeService gradeService;
	
	@RequestMapping(value="/getGradeList")
	@ResponseBody
	public List<String>getGradeList(){
		return gradeService.getGradeList();
	}
	

}
