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
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.StudentService;

@RequestMapping("/course")
@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
	@RequestMapping("/allcourse")
	public String name1(HttpServletRequest request, HttpServletResponse response,Model m) {
		List<Course> list=courseService.getAllListPart();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		m.addAttribute("json", json);
		return "jsp/course";
		
	}

	@RequestMapping("/details")
	public String name21(HttpServletRequest request, HttpServletResponse response,Model m) {
		Course course=new Course();
		course.setId(request.getParameter("cid"));
		course=courseService.getDetails(course);
		String str1=courseService.getCollect(course);
		String str2=courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
		m.addAttribute("json", json);
		return "jsp/course/course-details";
		
	}
	//取消收藏
	@RequestMapping("/details-off")
	public String name6(HttpServletRequest request, HttpServletResponse response,Model m) {
		//字段cid
	
		return "jsp/course/course-details";
		
	}
	@RequestMapping("/details-continue")
	public String name5(HttpServletRequest request, HttpServletResponse response,Model m) {
		//字段cid
	
		return "jsp/course/course-details";
		
	}
	@Autowired
	StudentService studentService;
	@RequestMapping("/studying")
	public String name2(HttpServletRequest request, HttpServletResponse response,Model m) {
		Student student=new Student();
		student.setId(request.getSession().getAttribute("id").toString());
		System.out.println("toString:"+request.getSession().getAttribute("id").toString());
		student=studentService.getStudentStudysCourse(student);
		String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
		m.addAttribute("json", json);
		return "jsp/course/course-study";
	}

	@RequestMapping("/studied")
	public String name3(HttpServletRequest request, HttpServletResponse response,Model m) {
		Student student = new Student();
		System.out.println("toString:"+request.getSession().getAttribute("id").toString());
		student.setId(request.getSession().getAttribute("id").toString());
		student = studentService.getStudentFinishCourse(student);
		String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
		m.addAttribute("json", json);
		return "jsp/course/course-studied";

	}

	@RequestMapping("/collect")
	public String name4(HttpServletRequest request, HttpServletResponse response,Model m) {
		Student student = new Student();
		System.out.println("toString:"+request.getSession().getAttribute("id").toString());
		student.setId(request.getSession().getAttribute("id").toString());
		student = studentService.getStudentCollectCourse(student);
		String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
		m.addAttribute("json", json);
		return "jsp/course/course-collect";
	}

}
