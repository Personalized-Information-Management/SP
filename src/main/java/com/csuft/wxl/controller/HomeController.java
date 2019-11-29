package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//logins
//logout
//zhuye
//course

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.StudentService;

@Controller
public class HomeController {
	@RequestMapping("/logins")
	public String name1() {
		return "forward:index";

	}

	@RequestMapping("/logout")
	public String name2(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("name", null);
		request.getSession().setAttribute("id", null);
		request.getSession().setAttribute("per", null);
		return "logout";
	}

	@Autowired
	StudentService studentService;

	@RequestMapping("/zhuye")
	public String name3(HttpServletRequest request, HttpServletResponse response, Model m) {
		if (request.getSession().getAttribute("name") == null) {
			return "forward:index";
		}
		Student student = new Student();
		student.setId((String) request.getSession().getAttribute("id"));
		student = studentService.getStudent(student);
		String json = String.format("{\"name\":\"%s\",\"id\":\"%s\",\"photo\":\"%s\"}", student.getStudent_name(),
				student.getId(), student.getSeudent_photo());
		m.addAttribute("json", json);
		return "zhuye";
	}
}
