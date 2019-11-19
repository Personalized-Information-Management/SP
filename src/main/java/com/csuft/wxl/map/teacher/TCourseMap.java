package com.csuft.wxl.map.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Teacher;

@Mapper
public interface TCourseMap {
	public List<Course> selectAllByTeacherId(Teacher teacher);

}
