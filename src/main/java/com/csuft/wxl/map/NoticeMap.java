package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;

@Mapper
public interface NoticeMap {
	public Student selectNotice(Student student);

	public int selectNotice_count(Student student);

	public List<Notice> selectNoticeStateById();

	// 选择消息通过学生id
	public List<Course> selectNoticeByStudent_id(Student student);

	public int selectNoticeByStudent_id_count(Student student);
}
