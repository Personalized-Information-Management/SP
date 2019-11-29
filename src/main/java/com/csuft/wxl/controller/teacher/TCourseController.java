package com.csuft.wxl.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.teacher.TCourseMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.pojo.UploadImageFile;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.TeacherService;

@RequestMapping("/teacher/course")
@Controller
public class TCourseController {

	@Autowired
	TeacherService teacherservice;
	@Autowired
	CourseService courseService;
	@Autowired
	TCourseMap tcoursemap;

	// 查看课程
	@RequestMapping("/details")
	public String name6(HttpServletRequest request, HttpServletResponse response, Model m) {
		Course course1 = new Course();
		course1.setId((String) request.getParameter("cid"));

		course1 = tcoursemap.selectCourseByCourseId(course1);
		String json = JSON.toJSONString(course1, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/course/course-details";
	}

	// 所有已发布的课程
	@RequestMapping("/published-course")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
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
		return "teacher/course/course-published";
	}

	// 创建课程页面
	@RequestMapping("/published")
	public String name2(HttpServletRequest request, HttpServletResponse response) {
		return "teacher/course/publish-edit";
	}

	// 处理发布的内容
	@ResponseBody
	@RequestMapping("/published-content")
	public String name4(HttpServletRequest request, HttpServletResponse response) {
		String str1 = (String) request.getParameter("course_id");
		String str2 = (String) request.getParameter("items");
		System.out.println(str2);
		Course course = new Course();
		course.setId(str1);
		course.setCourse_content(str2);
		System.out.println(course.toString());
		int a = courseservice.setCourseContent(course);
		return String.valueOf(a);
	}

	// 跳转到课程管理页面
	@RequestMapping("")
	public String name3(HttpServletRequest request, HttpServletResponse response) {
		return "teacher/course/course";
	}

	@Autowired
	CourseService courseservice;

	// 创建课程，创建文件夹
	@ResponseBody
	@RequestMapping("/course-image-uqload")
	public String name(HttpServletRequest request, HttpServletResponse response, UploadImageFile file)
			throws IllegalStateException, IOException {

//添加课程名，课程介绍,课程时间，课程图片，课程教师，课程文件夹course_folder
		Course course = new Course();
		course.setCourse_name(request.getParameter("course_name"));
		course.setCourse_introduce(request.getParameter("course_intr"));
		Date date = new Date();
		course.setCourse_time(String.valueOf(date.getTime()));

//		course.setCourse_teacher(String.valueOf(request.getSession().getAttribute("id")));
		course.setCourse_teacher("1");
		// 新建文件夹，设置folder,存放图片
		String folder = RandomStringUtils.randomAlphanumeric(10);
		String name = RandomStringUtils.randomAlphanumeric(10);
		String str = (String) request.getParameter("image_name");
		String[] str1 = str.split("[.]");
		String newFileName = name + "." + str1[str1.length - 1];
//创建按目录
		File direct = new File(UploadImageFile.REAL_COURSE_PATH + folder);
		while (direct.exists()) {
			String folder1 = RandomStringUtils.randomAlphanumeric(10);
			direct = new File(UploadImageFile.REAL_COURSE_PATH + folder);
		}
		direct.mkdirs();

		// 赋值文件夹属性
		course.setCourse_folder(UploadImageFile.VIRT_COURSE_PATH + direct.getName());
		// 存放图片
		File newFile = new File(direct.getPath(), newFileName);
		while (newFile.exists()) {
			name = RandomStringUtils.randomAlphanumeric(10);
			newFileName = name + "." + str1[str1.length - 1];
			newFile = new File(direct.getPath(), newFileName);
		}
		file.getImage().transferTo(newFile);
		course.setCourse_photo(course.getCourse_folder() + "/" + newFile.getName());
		course.setCourse_state("1");
		int a = courseservice.setCourseGetId(course);
//返回课程编号var data={"course_id":"%s","a":"%s"}
		String json = String.format("{\"course_id\":\"%s\",\"a\":\"%s\"}", course.getId(), a);
		return json;
	}

//编辑中上传的图片，重复上传不会删除文件
	@ResponseBody
	@RequestMapping("course-image-uqload1")
	public String name5(HttpServletRequest request, HttpServletResponse response, UploadImageFile file)
			throws IllegalStateException, IOException {
		Course course = new Course();
		course.setId((String) request.getParameter("course_id"));
		String folder1 = courseservice.getPathById(course);
		System.out.println(folder1);
		String[] str2 = folder1.split("/");
		// 课程文件夹
		String folder = str2[str2.length - 1];

		String str = (String) request.getParameter("imageName");
		String[] str1 = str.split("[.]");

		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name + "." + str1[str1.length - 1];
		File newFile = new File(UploadImageFile.REAL_COURSE_PATH + folder, newFileName);
		while (newFile.exists()) {
			name = RandomStringUtils.randomAlphanumeric(10);
			newFileName = name + "." + str1[str1.length - 1];
			newFile = new File(UploadImageFile.REAL_COURSE_PATH + folder, newFileName);
		}
		file.getImage().transferTo(newFile);
		String str3 = UploadImageFile.VIRT_COURSE_PATH + folder + "/" + newFile.getName();
		String json = String.format("<img src=\"%s\">", str3);
		return json;
	}

	// 删除课程,更具id删除课程
	@RequestMapping("/delete-course")
	public String name6(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("cid"));
		Notice notice = new Notice();
		notice.setId((String) request.getParameter("cid"));
		int num = tcoursemap.deleteCourseById(notice);
		return "redirect:/teacher/course/published-course";
	}

}
