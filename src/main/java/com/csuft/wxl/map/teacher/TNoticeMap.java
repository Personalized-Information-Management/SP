package com.csuft.wxl.map.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.Teacher;

@Mapper
public interface TNoticeMap {
	public List<Course> selectNoticeByTeacher(Teacher teacher);

	public int selectNoticeByTeacher_count(Teacher teacher);
	//删除
	public int deleteNoticByNoticeId(Notice notice);
	
	//插入
	public int insertOneNotice(Notice notice);
}
