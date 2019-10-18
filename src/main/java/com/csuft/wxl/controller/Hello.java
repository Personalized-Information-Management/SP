package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.User;

@RestController
public class Hello {
	@Autowired
	UserMap userMap;

	@RequestMapping("/hello")
	public String helloRequest(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("id", "20164255");
		ModelAndView mav = new ModelAndView();
		List<User> list = userMap.selectAll();

		return list.toString();
	}

	
}
