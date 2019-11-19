package com.csuft.wxl.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.service.TeacherService;

@RequestMapping("/teacher/published-course")
@Controller
public class TCourseController {
	@Autowired
	TeacherService teacherservice;
	@RequestMapping("")
	public String name(HttpServletRequest request, HttpServletResponse response,Model m) {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		List<Course> list=teacherservice.getCourse(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		return  "teacher/course-mg";
	}
}
