package com.jw.service;

import java.util.List;

import com.jw.pojo.VwClassGrade;

public interface ClassService {

	List<VwClassGrade> getClassList();
	List<String>getUserClass(Long gradeId);

}
