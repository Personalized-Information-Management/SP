package com.csuft.wxl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.User;

@Controller
public class Index {

	@Autowired
	UserMap userMap;

//	@RequestMapping("/index")
//	public String indexRequest(Model model, HttpServletRequest request, HttpServletResponse response) {
//		List<User> list=userMap.selectAll();
//		String str=JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
//		model.addAttribute("str", str);
//		return "jsp/index";
//	}
	@ResponseBody()
	@RequestMapping("/index")
	public String indexRequest(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<User> list = userMap.selectAll();
		String str = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		return str;
	}

	@ResponseBody()
	@RequestMapping("/logout")
	public String loginoutReques(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("id", null);
		return "退出登录";
	}

}
