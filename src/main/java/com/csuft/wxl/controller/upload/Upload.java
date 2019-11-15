package com.csuft.wxl.controller.upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/upload")
@Controller
public class Upload {
	@RequestMapping("/image")
	public String name(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "forward:发布.html";
	}

}
