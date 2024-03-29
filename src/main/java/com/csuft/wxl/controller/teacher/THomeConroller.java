package com.csuft.wxl.controller.teacher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.service.TeacherService;

@RequestMapping("/teacher")
@Controller
public class THomeConroller {
	@Autowired
	TeacherService teacherservice;

	@RequestMapping("/zhuye")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		if (request.getSession().getAttribute("id") == null) {
			return "forward:index";
		}
		Teacher teacher = new Teacher();
		teacher.setId(String.valueOf(request.getSession().getAttribute("id")));
		teacher = teacherservice.getIdAndPhoto(teacher);
		String json = String.format("{\"name\":\"%s\",\"id\":\"%s\",\"photo\":\"%s\"}", teacher.getTeacher_name(),
				teacher.getId(), teacher.getTeacher_photo());
		m.addAttribute("json", json);
		return "teacher/zhuye";
	}
}
