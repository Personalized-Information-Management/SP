package com.csuft.wxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.NoticeMap;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMap noticeMap;
	@Override
	public Student getNotice(Student student) {
		// TODO Auto-generated method stub
		return noticeMap.selectNotice(student);
	}

}
