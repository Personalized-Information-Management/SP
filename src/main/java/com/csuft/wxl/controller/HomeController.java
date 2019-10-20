package com.csuft.wxl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//logins
//logout
//zhuye
//course

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
		return "jsp/logout";
	}

	@RequestMapping("/zhuye")
	public String name3(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("name") == null) {
			return "forward:index";
		}
		return "jsp/zhuye";
	}

	@RequestMapping("/course")
	public String name4() {
		return "jsp/course";
	}

}
