package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;

@Mapper
public interface CourseMap {
	public int insertOne(Course course);

	public List<Course> selectAll();

	public List<Course> selectAllIdTeacherName();

	// 查询有错
	public Course selectCollect(Course course);

	public String selectCourseCollect(Course course);

	public String selectCourseStudy(Course course);
	
	//根据消息课程获取课程名
	public Course selectCourseRetuenCourseidCourseName(Notice notice);
}
