package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.service.CourseService;

@RequestMapping("/course")
@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
	@RequestMapping("/allcourse")
	public String name1(HttpServletRequest request, HttpServletResponse response,Model m) {
		List<Course> list=courseService.getAllList();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		m.addAttribute("json", json);
		return "jsp/course/courselist";
		
	}

	@RequestMapping("/allcourse/desc")
	public void name21(HttpServletRequest request, HttpServletResponse response) {

	}

	@RequestMapping("/studying")
	public void name2(HttpServletRequest request, HttpServletResponse response) {

	}

	@RequestMapping("/studied")
	public void name3(HttpServletRequest request, HttpServletResponse response) {

	}

	@RequestMapping("/collect")
	public void name4(HttpServletRequest request, HttpServletResponse response) {

	}

}
