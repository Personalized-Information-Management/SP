package com.csuft.wxl.service;

import java.util.List;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Teacher;

public interface TeacherService {
	// 获得所有发布的课程，更具教师id
	public List<Course> getCourse(Teacher teacher);

	public int getCourse_count(Teacher teacher);

	// 获取id图片，名字
	public Teacher getIdAndPhoto(Teacher teacher);

	// 获取一个教师发布的所有的课程的通知
	public List<Course> getNoticesByTeacher(Teacher teacher);

}
