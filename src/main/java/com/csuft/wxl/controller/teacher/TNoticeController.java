package com.csuft.wxl.controller.teacher;

import java.util.Date;
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
import com.csuft.wxl.map.teacher.TCourseMap;
import com.csuft.wxl.map.teacher.TNoticeMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.TeacherService;

@RequestMapping("/teacher/course")
@Controller
public class TNoticeController {
	@Autowired
	TeacherService teacherservice;

//已发布的通知
	@RequestMapping("/notice")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		List<Course> list = teacherservice.getNoticesByTeacher(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/notice/notice";
	}

	// 发布的所有课程
	@RequestMapping("/notice-course")
	public String name1(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		int num = teacherservice.getCourse_count(teacher);
		if (num != 0) {
			List<Course> list = teacherservice.getCourse(teacher);
			String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(json);
			m.addAttribute("data", json);
		} else {
			m.addAttribute("data", "\'\'");
		}
		return "teacher/notice/notice-allcourse";
	}

	@Autowired
	CourseService courseService;

	@Autowired
	TCourseMap tcoursemap;

	// 课程详情
	@RequestMapping("/notice/details")
	public String name3(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course1 = new Course();
		course1.setId((String) request.getParameter("cid"));

		course1 = tcoursemap.selectCourseByCourseId(course1);
		String json = JSON.toJSONString(course1, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/notice/course-details";
	}

	@Autowired
	TNoticeMap tnoticemap;

	// 删除通知
	@RequestMapping("/delete_notice")
	public String name4(HttpServletRequest request, HttpServletResponse response, Model m) {
		Notice notice = new Notice();
		notice.setId((String) request.getParameter("cid"));
		int num = tnoticemap.deleteNoticByNoticeId(notice);

		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		List<Course> list = teacherservice.getNoticesByTeacher(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/notice/notice";
	}
	//保存通知
	@ResponseBody
	@RequestMapping("/notice-publish")
	public String name5(HttpServletRequest request, HttpServletResponse response, Model m) {
		System.out.println();
		System.out.println();
		Notice notice=new Notice();
		notice.setNotice_courseid((String)request.getParameter("course_id"));
		notice.setNotice_content((String)request.getParameter("content"));
		Date date=new Date();
		notice.setNotice_time(String.valueOf(date.getTime()));
		int num=tnoticemap.insertOneNotice(notice);
		return String.valueOf(num);
	}
}
