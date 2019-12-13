package com.jw.dao;

import java.util.List;

import com.jw.pojo.VwClassGrade;

public interface ClassDao {
	public List<VwClassGrade> getClassList();
	
	public List<String>getUserClass(Long gradeId);

}
