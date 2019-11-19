package com.csuft.wxl.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.service.TeacherService;

@RequestMapping("/teacher/course")
@Controller
public class TCourseController {

	@Autowired
	TeacherService teacherservice;

	// 所有已发布的课程
	@RequestMapping("/published-course")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		List<Course> list = teacherservice.getCourse(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		return "teacher/course-mg";
	}

	// 跳转到发布页面
	@RequestMapping("/published")
	public String name2(HttpServletRequest request, HttpServletResponse response) {
		return "teacher/publish-edit";
	}

	// 处理发布的内容
	@ResponseBody
	@RequestMapping("/published")
	public String name4(HttpServletRequest request, HttpServletResponse response) {
		return "true";

	}

	// 跳转到课程管理页面
	@RequestMapping("")
	public String name3(HttpServletRequest request, HttpServletResponse response) {
		return "teacher/course";
	}

}
