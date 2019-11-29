package com.csuft.wxl.service;

import java.util.List;
import java.util.Map;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;

public interface CourseService {

	List<Course> getAllList();

	List<Course> getAllListPart();

	int getAllListPart_count();

	Course getDetails(Course course);

	public String getCollect(Course course);

	public String getStudy(Course course);

	public Course getCourseByNotice(Notice notice);
	public int getCourseByNotice_count(Notice notice);

	public int setCourseGetId(Course course);

	public String getPathById(Course course);

	public int setCourseContent(Course course);

	public int getCountStudent_idCourse_id(Map<String, String> map);

	public int setStudentCourseToStudetn_Course(Map<String, String> map);

	public int modifyCollect(Map<String, String> map);

	public int modifyStudy(Map<String, String> map);

	public Course getContent(Course course);

	public int setStudyState(Map<String, String> map);

	public int setStudyNull(Map<String, String> map);

	public int setCollectNull(Map<String, String> map);

}
