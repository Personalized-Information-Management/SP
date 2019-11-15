package com.csuft.wxl.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.UploadImageFile;
import com.csuft.wxl.service.StudentService;

@RequestMapping("/persion")
@Controller
public class PersionController {
	@Autowired
	StudentService studetService;

	@RequestMapping("/edit")
	public String name3(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String) request.getParameter("id"));
		student.setStudent_name((String) request.getParameter("student_name"));
		student.setStudent_sex((String) request.getParameter("student_sex"));
		student.setStudent_phone((String) request.getParameter("student_phone"));
		student.setStudent_col((String) request.getParameter("student_col"));
		student.setStudent_majo((String) request.getParameter("student_majo"));
		int a = studetService.modifyStudnt(student);
		System.out.println("student:" + student.toString());
		System.out.println("a:" + a);
		String str = null;
		if (a == 1) {
			request.getSession().setAttribute("name", student.getStudent_name());
			request.getSession().setAttribute("id", student.getId());
			str = String.format("{str:'%s',photo:'%s'}", "修改成功", "/img/成功.png");
		} else {
			str = String.format("{str:'%s',photo:'%s'}", "修改失败", "/img/失败-01.png");
		}
		m.addAttribute("json", str);
		return "jsp/persion/succeed";
	}

	@RequestMapping("/persion-edit")
	public String name2(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String)request.getSession().getAttribute("id"));
		student = studetService.getStudent(student);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		return "jsp/persion/persion-edit";
	}

	@RequestMapping("")
	public String name1(HttpServletRequest request, HttpServletResponse response, Model m) {
		Student student = new Student();
		student.setId((String)request.getSession().getAttribute("id"));
		student = studetService.getStudent(student);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		m.addAttribute("json", json);
		return "jsp/persion/persion";
	}
	@ResponseBody
	@RequestMapping("/upload")
	public String name(HttpServletRequest request, HttpServletResponse response, UploadImageFile file,Model m) throws IllegalStateException, IOException {
		Student student = new Student();
		student.setId((String)request.getSession().getAttribute("id"));
		student = studetService.getStudent(student);
		if (student.getSeudent_photo() != null) {
			String str = student.getSeudent_photo();
			String[] str2 = str.split(UploadImageFile.VIRT_STUDENT_PATH);
			if (!str2[str2.length - 1].equals("")) {
				String str3 = UploadImageFile.REAL_STUDENT_PATH + str2[str2.length - 1];
				File file1 = new File(str3);
				if (file1.exists()) {
					file1.delete();
				} 
			} 
		}
		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name+".png";
		File newFile = new File(UploadImageFile.REAL_STUDENT_PATH, newFileName);
		if (newFile.exists()) {
			file.getImage().transferTo(newFile);
		}else {
			newFile.getParentFile().mkdirs();
			file.getImage().transferTo(newFile);
		}
		//根据学生上传图片
		//文件
		System.out.println("文件名："+newFileName);
		student.setSeudent_photo(UploadImageFile.VIRT_STUDENT_PATH+newFileName);
		int a=studetService.modifyStudntPhoto(student);
		if (a==0) {
			return "false";
		}
		return "true";
	}

}
