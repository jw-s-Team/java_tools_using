package com.jw.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.GradeDao;
import com.jw.pojo.Grade;
import com.jw.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
	@Autowired
	GradeDao gradeDao;

	@Override
	public List<String> getGradeList() {
		return gradeDao.getGradeList();
	}

}
