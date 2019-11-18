package com.csuft.wxl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	CourseService courseService;
	@Autowired
	NoticeService noticeService;

	@RequestMapping("/notice")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String) request.getSession().getAttribute("id"));
		student = noticeService.getNotice(student);

		List<Course> list = new ArrayList<Course>();
		for (Notice notice : student.getNotices()) {
			Course course = new Course();
			course = courseService.getCourseByNotice(notice);
			list.add(course);
		}
		student.setCourse(list);
		List<Map> list1 = new ArrayList<Map>();
		for (int i = 0; i < student.getCourse().size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("courses", student.getCourse().get(i));
			map.put("notices", student.getNotices().get(i));
			list1.add(map);
		}
		String json = JSON.toJSONString(list1, SerializerFeature.WriteMapNullValue);

		m.addAttribute("json", json);
		return "notice/notice";
	}
}
