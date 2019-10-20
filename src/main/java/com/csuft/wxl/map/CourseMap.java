package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;

@Mapper
public interface CourseMap {
	public int insertOne(Course course);
	public List<Course> selectAll();
}
