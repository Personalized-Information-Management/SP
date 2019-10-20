package com.csuft.wxl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.CourseMap;
import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.UserService;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpApplicationTests {
	// 测试mybatis
	@Autowired
	UserMap userMap;
	@Autowired
	CourseMap courseMap;
	@Autowired
	UserService userService;
	@Autowired
	CourseService courseService;
	@Test
	public void name2() {
		List<Course> list=courseService.getAllList();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		for (Course course : list) {
			System.out.println(course.toString());
			
		}
	}

//	@Test
	public void name1() {
		User user = new User();
		user.setId("1");
		user.setUser_per("3");
		String name = userService.getName(user);
		if (name == null) {
			System.out.println("name==null");
		} else if (name.equals("")) {
			System.out.println("name.equals(\"\")");
		}
		System.out.println("\n" + name + "\n");
	}

//	@Test
	public void name() {
		User user = new User();
		user.setId("1");
		user.setUser_per("2");
		user.setUser_pwd(userService.getPassword(user));
		System.out.println(user);

	}

//	@Test
	public void contextLoads1() {
		List<User> list = userMap.selectAll();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

	public static List<Course> getList() {
		CsvReader csvReader = CsvUtil.getReader();
		CsvData data = csvReader.read(FileUtil.file("C:\\Users\\Administrator\\Desktop\\练习\\course.csv"),
				CharsetUtil.CHARSET_GBK);
		List<CsvRow> rows = data.getRows();
		List<Course> list = new ArrayList<Course>();
		rows.remove(0);
		for (CsvRow csvRow : rows) {
			Course course = new Course();
			course.setCourse_time(csvRow.get(0));
			course.setId(csvRow.get(1));
			course.setCourse_name(csvRow.get(2));
			course.setCourse_introduce(csvRow.get(3));
			course.setCourse_collect(csvRow.get(4));
			course.setCourse_apply(csvRow.get(5));
			course.setCourse_teacher(csvRow.get(6));
			course.setCourse_photo(csvRow.get(7));
			list.add(course);
		}
		return list;
	}

	static int a = 0;

//	@Test
	public void fun1() {
		List<Course> list = getList();
		for (Course course : list) {
			int b = courseMap.insertOne(course);
			System.out.println("执行到");
			a = b + a;
		}
		System.out.println("数据库修改条数:" + a + "\t" + list.size());

	}

}
