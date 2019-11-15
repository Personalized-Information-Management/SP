package com.csuft.wxl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Discuss;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.DiscussService;
import com.csuft.wxl.service.StudentService;

@RequestMapping("/dis")
@Controller
public class DiscussController {
	@RequestMapping("/delete")
	public void name4() {
		
	}
	@ResponseBody
	@RequestMapping("/publish")
	public String name3(HttpServletRequest request, HttpServletResponse response) {
		Discuss discuss = new Discuss();
		discuss.setDis_auto((String) request.getSession().getAttribute("id"));
		discuss.setDis_per((String) request.getSession().getAttribute("per"));
		discuss.setDis_title((String) request.getParameter("title"));
		discuss.setDis_content((String) request.getParameter("html"));
		Date date = new Date();
		discuss.setDis_time(String.valueOf(date.getTime()));
		System.out.println(discuss.toString());
		int a = discussService.setDis(discuss);
		int error = 0;
		if (a == 1) {
			error = 0;
		} else {
			error = 1;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("error", error);
		map.put("data", a);
		String json = JSON.toJSONString(map);
		return json;
	}

	@Autowired
	DiscussService discussService;
	@Autowired
	StudentService studentService;

	@RequestMapping("")
	public String name1(HttpServletRequest request, HttpServletResponse response, Model m) {
		// 需要账户姓名，账户，发布人姓名，发布人头像，发布标题，发布内容，有多少赞，有多少收藏，有多少条回复，
		List<Discuss> list = discussService.getAllDisAndAuthorList();
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		Student student = new Student();
		student.setId((String) request.getSession().getAttribute("id"));
		student.setStudent_per((String) request.getSession().getAttribute("per"));
		student = studentService.getStudent(student);
		String json1 = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		m.addAttribute("json1", json1);
		return "jsp/discuss/discuss";
	}
}
