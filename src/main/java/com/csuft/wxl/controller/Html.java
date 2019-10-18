package com.csuft.wxl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Html {
	@RequestMapping("/login")
	public String show() {
		return "login";
	}

//	@ResponseBody()
	@RequestMapping("/hello.html")
	public String helloHtmlRequest() {
		return "hello";
	}
}
