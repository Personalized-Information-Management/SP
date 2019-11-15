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

	@Override
	public List<Course> getAllListPart() {
		// TODO Auto-generated method stub
		return courseMap.selectAllIdTeacherName();
	}

	@Override
	public Course getDetails(Course course) {
		// TODO Auto-generated method stub
		return courseMap.selectCollect(course);
	}

	

	@Override
	public String getCollect(Course course) {
		// TODO Auto-generated method stub
		return courseMap.selectCourseCollect(course);
	}

	@Override
	public String getStudy(Course course) {
		// TODO Auto-generated method stub
		return courseMap.selectCourseStudy(course);
	}

}
