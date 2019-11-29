package com.csuft.wxl.controller.teacher;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.teacher.TeacherMap;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.pojo.UploadImageFile;

@RequestMapping("/teacher/persion")
@Controller
public class TPersionController {
	@Autowired
	TeacherMap teachermap;

//个人信息页面
	@RequestMapping("")
	public String name(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		teacher = teachermap.selectTeacherById(teacher);
		String json = JSON.toJSONString(teacher, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/persion/persion";
	}

	// 编辑个人信息页面
	@RequestMapping("/persoin-edit")
	public String name2(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		teacher = teachermap.selectTeacherById(teacher);
		String json = JSON.toJSONString(teacher, SerializerFeature.WriteMapNullValue);
		m.addAttribute("data", json);
		return "teacher/persion/persion-edit";
	}

	// 保存修改
	@RequestMapping("/edit")
	public String name4(HttpServletRequest request, HttpServletResponse response, Model m) {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getParameter("id"));
		teacher.setTeacher_name((String) request.getParameter("teacher_name"));
		teacher.setTeacher_sex((String) request.getParameter("teacher_sex"));
		teacher.setTeacher_phone((String) request.getParameter("teacher_phone"));
		teacher.setTeacher_coll((String) request.getParameter("teacher_coll"));
		teacher.setTeacher_rank((String) request.getParameter("teacher_rank"));
		int a = teachermap.updateTeacher(teacher);
		String str = null;
		if (a == 1) {
			request.getSession().setAttribute("name", teacher.getTeacher_name());
			request.getSession().setAttribute("id", teacher.getId());
			str = String.format("{str:'%s',photo:'%s'}", "修改成功", "/img/成功.png");
		} else {
			str = String.format("{str:'%s',photo:'%s'}", "修改失败", "/img/失败-01.png");
		}
		m.addAttribute("json", str);
		return "teacher/persion/succeed";
	}

	// 个人信息界面上传图片
	@RequestMapping("/upload")
	@ResponseBody
	public String name3(HttpServletRequest request, HttpServletResponse response, UploadImageFile file, Model m)
			throws IllegalStateException, IOException {
		Teacher teacher = new Teacher();
		teacher.setId((String) request.getSession().getAttribute("id"));
		teacher = teachermap.selectTeacherById(teacher);
		// 删除原图
		if (teacher.getTeacher_photo() != null) {
			String str = teacher.getTeacher_photo();
			String[] str2 = str.split(UploadImageFile.VIRT_TEACHER_PATH);
			if (!str2[str2.length - 1].equals("")) {
				String str3 = UploadImageFile.REAL_TEACHER_PATH + str2[str2.length - 1];
				System.out.println("str3" + str3);
				File file1 = new File(str3);
				if (file1.exists()) {
					file1.delete();
				}
			}
		}
		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name + ".png";
		File newFile = new File(UploadImageFile.REAL_TEACHER_PATH, newFileName);
		if (newFile.exists()) {
			file.getImage().transferTo(newFile);
		} else {
			newFile.getParentFile().mkdirs();
			file.getImage().transferTo(newFile);
		}
		// 根据学生上传图片
		// 文件
		System.out.println("文件名：" + newFileName);
		teacher.setTeacher_photo(UploadImageFile.VIRT_TEACHER_PATH + newFileName);

		int a = teachermap.updateTeacherPhone(teacher);

		return String.valueOf(a);
	}

	// 跳转到修改密码界面
	@RequestMapping("/edit-pwd")
	public String name5(HttpServletRequest request, HttpServletResponse response, Model m) {
		String id = (String) request.getSession().getAttribute("id");
		m.addAttribute("id", id);
		return "teacher/persion/edit-pwd";
	}

	@ResponseBody
	@RequestMapping("/edit-pwd-req")
	public String name(HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getParameter("id");
		String old_pwd = (String) request.getParameter("old_pwd");
		String renew_pwd = (String) request.getParameter("renew_pwd");
//		System.out.println("id:"+id+"\n"+"old_pwd:"+old_pwd+"\n"+"renew_pwd:"+renew_pwd);
		Teacher teacher = new Teacher();
		teacher.setId(id);
		String num = teachermap.selectPwd(teacher);
		String data = null;
		if (num.equals(old_pwd)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("pwd", renew_pwd);
			int num1 = teachermap.updatePwd(map);
			if (num1 == 0) {
				data = String.format("{\"err\":\"%s\",\"data\":\"%s\"}", "true", "密码未改变");
			} else {
				data = String.format("{\"err\":\"%s\",\"data\":\"%s\"}", "true", "密码已改变");
			}
			return data;
		} else {
			data = String.format("{\"err\":\"%s\",\"data\":\"%s\"}", "false", "原密码输入错误");
			return data;
		}

	}

}
