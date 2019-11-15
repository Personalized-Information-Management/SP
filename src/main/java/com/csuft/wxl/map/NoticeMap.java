package com.csuft.wxl.map;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Student;

@Mapper
public interface NoticeMap {
	public Student selectNotice(Student student);
}
