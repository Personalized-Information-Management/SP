package com.csuft.wxl.service;

import java.util.List;

import com.csuft.wxl.pojo.Course;

public interface CourseService {
	List<Course> getAllList();

	List<Course> getAllListPart();

	Course getDetails(Course course);
	
	public String getCollect(Course course);
	
	public String getStudy(Course course);
}
