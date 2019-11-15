package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;

@Mapper
public interface CourseMap {
	public int insertOne(Course course);

	public List<Course> selectAll();

	public List<Course> selectAllIdTeacherName();

	// 查询有错
	public Course selectCollect(Course course);

	public String selectCourseCollect(Course course);

	public String selectCourseStudy(Course course);
}
