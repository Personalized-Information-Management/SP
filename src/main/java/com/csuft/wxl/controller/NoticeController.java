package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.NoticeMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	CourseService courseService;
	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeMap noticeMap;

	@RequestMapping("/notice")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String) request.getSession().getAttribute("id"));
		List<Course> course = noticeMap.selectNoticeByStudent_id(student);
		String json = JSON.toJSONString(course, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "notice/notice";
	}
}
