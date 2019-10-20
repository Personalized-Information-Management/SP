package com.csuft.wxl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.UserService;
//
//login
//index


@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping("/")
    public String index()  {
        return "forward:index";
    }
	@RequestMapping("/index")
	public String indexRequest() {
		return "/login.html";
	}
	@RequestMapping("/login")
	public String loginRequest(HttpServletRequest request, HttpServletResponse response, Model m) {
		User user = new User();
		user.setId(request.getParameter("name"));
		user.setUser_per(request.getParameter("role"));
		user.setUser_pwd(request.getParameter("password"));
		String pwd = userService.getPassword(user);
		if (user.getId() != null && user.getUser_pwd().equals(pwd)) {
			System.out.println(user);
			String name=userService.getName(user);
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("id", user.getId());
			request.getSession().setAttribute("per", user.getUser_per());
			return "jsp/zhuye";
			// 输出结果为空
		} else {
			return "jsp/login";
		}

	}
}
