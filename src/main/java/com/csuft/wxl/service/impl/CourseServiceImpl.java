package com.csuft.wxl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.CourseMap;
import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
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

	@Override
	public Course getCourseByNotice(Notice notice) {
		// TODO Auto-generated method stub
		return courseMap.selectCourseRetuenCourseidCourseName(notice);
	}

	@Override
	public int setCourseGetId(Course course) {
		// TODO Auto-generated method stub
		return courseMap.insertReturnId(course);
	}

	@Override
	public String getPathById(Course course) {
		// TODO Auto-generated method stub
		return courseMap.selectPathById(course);
	}

	@Override
	public int setCourseContent(Course course) {
		// TODO Auto-generated method stub
		return courseMap.insertContentByid(course);
	}

	@Override
	public int getAllListPart_count() {
		// TODO Auto-generated method stub
		return courseMap.selectAllIdTeacherName_count();
	}

	@Override
	public int getCountStudent_idCourse_id(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.selectCollentExist(map);
	}

	@Override
	public int setStudentCourseToStudetn_Course(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.insertOneStudent_idCourse_id(map);
	}

	@Override
	public int modifyCollect(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.updateCollectByStudetnCourse(map);
	}

	@Override
	public Course getContent(Course course) {
		// TODO Auto-generated method stub
		return courseMap.selectCourseContentById(course);
	}

	@Override
	public int setStudyState(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.insertOneStudyStudent_idCourse_id(map);
	}

	@Override
	public int modifyStudy(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.updateStudyByStudetnCourse(map);
	}

	@Override
	public int setStudyNull(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.updateStudytoNull(map);
	}

	@Override
	public int setCollectNull(Map<String, String> map) {
		// TODO Auto-generated method stub
		return courseMap.updateCollecttoNull(map);
	}

	@Override
	public int getCourseByNotice_count(Notice notice) {
		// TODO Auto-generated method stub
		return courseMap.selectCourseRetuenCourseidCourseName_conut(notice);
	}

}
