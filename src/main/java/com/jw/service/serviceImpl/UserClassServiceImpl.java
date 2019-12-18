package com.jw.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.dao.UserClassDao;
import com.jw.pojo.UserClass;
import com.jw.service.UserClassService;

@Service
public class UserClassServiceImpl implements UserClassService {
	@Autowired
	UserClass userClass;
	@Autowired
	UserClassDao userClassDao;
	
	@Override
	public void newOneUserClass(Long userId, Long classId) {
		userClass.setClassId(classId);
		userClass.setUserId(userId);
		userClass.setCreateTime(new Date());
		userClass.setLastModifyTime(new Date());
		userClassDao.newOneUserClass(userClass);
	}

	@Override
	public void delOneUserClass(Long userId, Long classId) {
		Map<String,Long> params=new HashMap<String, Long>();
		params.put("userId", userId);
		params.put("classId", classId);
		userClassDao.delOneUserClass(params);
		
	}

}
