package com.csuft.wxl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// 所有课程
	@RequestMapping({ "/allcourse", "" })
	public String name1(HttpServletRequest request, HttpServletResponse response, Model m) {
		int num = courseService.getAllListPart_count();
		if (num != 0) {
			List<Course> list = courseService.getAllListPart();
			String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
			m.addAttribute("data", json);
		} else {
			m.addAttribute("data", "\'\'");
		}
		return "course/course-all";
	}

	@Autowired
	StudentService studentService;

	// 正在学习的课程
	@RequestMapping("/studying")
	public String name2(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId(request.getSession().getAttribute("id").toString());

		int num = studentService.getStudentStudysCourse_count(student);
		if (num != 0) {
			student = studentService.getStudentStudysCourse(student);
			String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
			m.addAttribute("data", json);
		} else {
			m.addAttribute("data", "\'\'");
		}

		return "course/course-studing";
	}

	@RequestMapping("/studied")
	public String name3(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId(request.getSession().getAttribute("id").toString());
		int num = studentService.getStudentFinishCourse_count(student);
		if (num != 0) {
			student = studentService.getStudentFinishCourse(student);
			String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
			m.addAttribute("data", json);
		} else {
			m.addAttribute("data", "\'\'");
		}
		return "course/course-studied";
	}

	@RequestMapping("/collect")
	public String name4(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId(request.getSession().getAttribute("id").toString());

		int num = studentService.getStudentCollectCourse_count(student);
		if (num != 0) {
			student = studentService.getStudentCollectCourse(student);
			String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
			m.addAttribute("data", json);
		} else {
			m.addAttribute("data", "\'\'");
		}
		return "course/course-collect";
	}

	@RequestMapping("/details")
	public String name21(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course = new Course();
		course.setId(request.getParameter("cid"));
		course = courseService.getDetails(course);
		String str1 = courseService.getCollect(course);
		String str2 = courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
		m.addAttribute("data", json);
		return "course/course-details";
	}
	@RequestMapping("/details1")
	public String name24(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course = new Course();
		course.setId(request.getParameter("cid"));
		course = courseService.getDetails(course);
		String str1 = courseService.getCollect(course);
		String str2 = courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
		m.addAttribute("data", json);
		return "course/course-details1";
	}
	@RequestMapping("/details2")
	public String name25(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course = new Course();
		course.setId(request.getParameter("cid"));
		course = courseService.getDetails(course);
		String str1 = courseService.getCollect(course);
		String str2 = courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
		m.addAttribute("data", json);
		return "course/course-details2";
	}



	// 收藏请求处理
	@ResponseBody
	@RequestMapping("/collect-req")
	public String name22(HttpServletRequest request, HttpServletResponse response, Model m) {
//判断学生和课程的记录是否存在
		Map<String, String> map = new HashMap<String, String>();
		map.put("student_id", (String) request.getSession().getAttribute("id"));
		map.put("course_id", String.valueOf(request.getParameter("course_id")));

		int num = courseService.getCountStudent_idCourse_id(map);
		int a = -1;
		if (num != 1) {
			// 插入数据库，sql语句一设置collect=1
			a = courseService.setStudentCourseToStudetn_Course(map);
		} else {
			// 更新数据
			a = courseService.modifyCollect(map);
		}
		System.out.println("插入影响的行：" + a);
		return String.valueOf(a);
	}

	// 添加到学习
	@ResponseBody
	@RequestMapping("/study-req")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("student_id", (String) request.getSession().getAttribute("id"));
		map.put("course_id", String.valueOf(request.getParameter("course_id")));
		int num = courseService.getCountStudent_idCourse_id(map);
		int a = -1;
		if (num != 1) {
			// 插入数据库，sql语句一设置study=1
			a = courseService.setStudyState(map);
		} else {
			// 更新数据
			a = courseService.modifyStudy(map);
		}
		System.out.println("插入影响的行：" + a);
		return String.valueOf(a);
	}

	// 从学习移除
	@ResponseBody
	@RequestMapping("/studyoff-req")
	public String name5(HttpServletRequest request, HttpServletResponse response, Model m) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("student_id", (String) request.getSession().getAttribute("id"));
		map.put("course_id", String.valueOf(request.getParameter("course_id")));
		int a = -1;
		// 更新数据
		a = courseService.setStudyNull(map);
		System.out.println("插入影响的行：" + a);
		return String.valueOf(a);
	}

	// 从收藏中移除
	@ResponseBody
	@RequestMapping("/collectoff-req")
	public String name6(HttpServletRequest request, HttpServletResponse response, Model m) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("student_id", (String) request.getSession().getAttribute("id"));
		map.put("course_id", String.valueOf(request.getParameter("course_id")));
		int a = -1;
		// 更新数据
		a = courseService.setCollectNull(map);
		System.out.println("插入影响的行：" + a);
		return String.valueOf(a);
	}

//进入课程
	@RequestMapping("/display")
	public String name23(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course = new Course();
		course.setId((String) request.getParameter("cid"));
		course = courseService.getContent(course);
		String json = JSON.toJSONString(course, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "course/course-display";
	}

}
