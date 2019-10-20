package com.csuft.wxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.CourseMap;
import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.UserService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMap courseMap;

	@Override
	public List<Course> getAllList() {
		// TODO Auto-generated method stub
		return courseMap.selectAll();
	}

}
