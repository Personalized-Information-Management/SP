package com.csuft.wxl.service;

import com.csuft.wxl.pojo.Student;

public interface NoticeService {

	public Student getNotice(Student student);

	public int getNotic_count(Student student);
}
