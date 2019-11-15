package com.csuft.wxl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.StudentService;
import com.csuft.wxl.service.UserService;
//
//login
//index

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String index() {
		return "forward:index";
	}

	@RequestMapping("/index")
	public String indexRequest() {
		return "/login.html";
	}

	@Autowired
	StudentService studentService;

	@RequestMapping("/login")
	public String loginRequest(HttpServletRequest request, HttpServletResponse response, Model m) {
		User user = new User();
		user.setId(request.getParameter("name"));
		user.setUser_per(request.getParameter("role"));
		user.setUser_pwd(request.getParameter("password"));
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
				m.addAttribute("photo", "\"" + student.getSeudent_photo() + "\"");
				return "jsp/zhuye";
			} else if (user.getUser_per().equals("2")) {
				return "jsp/teacher/zhuye";
			} else {
				return "jsp/login";
			}
			// 输出结果为空
		} else {
			return "jsp/login";
		}

	}
}
