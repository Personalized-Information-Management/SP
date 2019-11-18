package com.csuft.wxl.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teacher")
@Controller
public class HomeConroller {
	@RequestMapping("/zhuye")
	public String name() {
		return null;
	}
}
