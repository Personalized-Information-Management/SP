package com.csuft.wxl.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;

@Mapper
public interface NoticeMap {
	public Student selectNotice(Student student);
	
	public List<Notice> selectNoticeStateById();
}
