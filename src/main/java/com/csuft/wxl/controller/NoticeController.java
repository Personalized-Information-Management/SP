package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Discuss;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	NoticeService noticeService;
	@RequestMapping("")
	public void name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String) request.getSession().getAttribute("id"));
		student = noticeService.getNotice(student)
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		return "jsp/discuss/discuss";
	}
}
