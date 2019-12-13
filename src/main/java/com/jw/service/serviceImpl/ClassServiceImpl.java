package com.jw.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.ClassDao;
import com.jw.pojo.VwClassGrade;
import com.jw.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	ClassDao classDao;

	@Override
	public List<VwClassGrade> getClassList() {
		return classDao.getClassList();
	}

	@Override
	public List<String> getUserClass(Long gradeId) {
		return classDao.getUserClass(gradeId);
	}

}
