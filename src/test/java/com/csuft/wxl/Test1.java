package com.csuft.wxl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;

public class test1 {
	public static void main9(String[] args) {
//		时间
		Date date=new Date();
		System.out.println(date.getTime());
	}

	public static void main8(String[] args) {
		List<Notice> list = new ArrayList<Notice>();
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		System.out.println(json);

	}

	public static void main7(String[] args) {
		String str = "/images/course/yvnCjsH1rz";
		String[] str2 = str.split("/");
		System.out.println(str2[str2.length - 1]);
	}

	public static void main6(String[] args) {
//		String folder = RandomStringUtils.randomAlphanumeric(10);
		String folder = "a7ZOmCgTqV";
		File file = new File("D:/img/course/" + folder);
		file.mkdirs();
		System.out.println(file.getName());
	}

	public static void main5(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
	}

	public static void main4(String[] args) {
		String string = "sdfqdf.jpg";
		String[] strings = string.split("[.]");
		System.out.println(strings[strings.length - 1]);
	}

	public static void main3(String[] args) {
		Student student = new Student();
		List<Course> courses = new ArrayList<Course>();
		Course course1 = new Course();
		course1.setId("1");
		Course course2 = new Course();
		course2.setId("2");
		courses.add(course1);
		courses.add(course2);
		List<Notice> notices = new ArrayList<Notice>();
		Notice notice1 = new Notice();
		notice1.setId("3");
		Notice notice2 = new Notice();
		notice2.setId("4");
		notices.add(notice1);
		notices.add(notice2);

		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < notices.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("courses", courses.get(i));
			map.put("notices", notices.get(i));
			list.add(map);
		}
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

	public static void main2(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\新建文件夹/世界.txt");
		file.createNewFile();
	}

	public static void main1(String[] args) {
		String str = "{\"id\":\"1\",\"notice_content\":\"<p>我的世界，你的世界，他的世界</p>\",\"notice_courseid\":\"1\",\"notice_read\":\"1\",\"notice_time\":\"1573794990000\",\"student_id\":\"1\"}";
		String str1 = "{\"id\":\"4\",\"notice_content\":\"<p>请完成第三张的内容</p>\",\"notice_courseid\":\"5\",\"notice_read\":\"1\",\"notice_time\":\"1573794990000\",\"student_id\":\"1\"}";
		String str2 = "{\"id\":\"2\",\"notice_content\":\"<p>请完成第二张的内容</p>\",\"notice_courseid\":\"1\",\"notice_read\":\"1\",\"notice_time\":\"1573794990000\",\"student_id\":\"1\"}";
		String str3 = "{\"id\":\"3\",\"notice_content\":\"<p>请完成第三张的内容</p>\",\"notice_courseid\":\"1\",\"notice_read\":null,\"notice_time\":\"1573794990000\",\"student_id\":\"1\"}";
		String str4 = "{\"id\":\"5\",\"notice_content\":\"<p>请完成第三张的内容</p>\",\"notice_courseid\":\"8\",\"notice_read\":null,\"notice_time\":\"1573794990000\",\"student_id\":\"1\"}";
		String[] str5 = { str, str1, str2, str3, str4 };
		List<Notice> list = new ArrayList<Notice>();
		for (String str6 : str5) {
			JSONObject use1 = JSONObject.parseObject(str6);
			Notice notice = JSON.toJavaObject(use1, Notice.class);
			list.add(notice);
		}
		System.out.println(list.get(1).getNotice_read().equals("1"));
		List<Notice> list1 = new ArrayList<Notice>();
		List<Notice> list2 = new ArrayList<Notice>();
		for (Notice notice : list) {
			if (notice.getNotice_read() == null) {

			}
			System.out.println(notice);
		}

	}
}
