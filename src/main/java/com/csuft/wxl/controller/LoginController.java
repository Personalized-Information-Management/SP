package com.csuft.wxl.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.StudentService;
import com.csuft.wxl.service.TeacherService;
import com.csuft.wxl.service.UserService;
//
//login
//index

@Controller
public class LoginController {
	@ResponseBody
	@RequestMapping("/path")
	public String name(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {

		File path = new File(ResourceUtils.getURL("classpath:").getPath());

		String rootPath = Class.class.getClass().getResource("/").getPath();
		String rootPath2 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
		System.out.println("classpath的地址" + path.getAbsolutePath());
		System.out.println("根路径" + rootPath);
		System.out.println("根路径" + rootPath2);
		return null;
	}

	@Autowired
	UserService userService;

	@RequestMapping({ "/index", "/" })
	public String indexRequest() {
		return "login";
	}

	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherservice;

	@RequestMapping("/login")
	public String loginRequest(HttpServletRequest request, HttpServletResponse response, Model m) {
		User user = new User();
		user.setId(request.getParameter("name"));
		user.setUser_per(request.getParameter("role"));
		user.setUser_pwd(request.getParameter("password"));
		System.out.println(user);
		String pwd = userService.getPassword(user);
		if (user.getId() != null && user.getUser_pwd().equals(pwd)) {
			if (user.getUser_per().equals("1")) {
				String name = userService.getName(user);
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("id", user.getId());
				request.getSession().setAttribute("per", user.getUser_per());
				Student student = new Student();
				student.setId((String) user.getId());
				student = studentService.getStudent(student);
				String json = String.format("{\"name\":\"%s\",\"id\":\"%s\",\"photo\":\"%s\"}", student.getStudent_name(), student.getId(),
						student.getSeudent_photo());
				m.addAttribute("json", json);
				return "zhuye";
			} else if (user.getUser_per().equals("2")) {
				Teacher teacher=new Teacher();
				teacher.setId((String)user.getId());
				teacher= teacherservice.getIdAndPhoto(teacher);
				
				request.getSession().setAttribute("name", teacher.getTeacher_name());
				request.getSession().setAttribute("id", user.getId());
				request.getSession().setAttribute("per", user.getUser_per());
				String json = String.format("{\"name\":\"%s\",\"id\":\"%s\",\"photo\":\"%s\"}", teacher.getTeacher_name(), teacher.getId(),teacher.getTeacher_photo());
				m.addAttribute("json", json);
				return "teacher/zhuye";
			} else {
				return "login";
			}
			// 输出结果为空
		} else {
			return "login";
		}

	}

}
