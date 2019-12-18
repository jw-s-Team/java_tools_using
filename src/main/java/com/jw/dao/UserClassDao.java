package com.jw.dao;


import java.util.Map;

import com.jw.pojo.UserClass;

public interface UserClassDao {;
	public void newOneUserClass(UserClass userClass);

	public void delOneUserClass(Map<String, Long> params);
}
