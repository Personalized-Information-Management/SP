package com.csuft.wxl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.User;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

public class Test1 {
	public static void main(String[] args) {
		Course course=getOne();
		System.out.println(course);
	}
	public static Course getOne() {
		CsvReader csvReader = CsvUtil.getReader();
		CsvData data = csvReader.read(FileUtil.file("C:\\Users\\Administrator\\Desktop\\练习\\course.csv"),
				CharsetUtil.CHARSET_GBK);
		List<CsvRow> rows = data.getRows();
		rows.remove(0);
		CsvRow csvRow=rows.get(0);
		Course course = new Course();
		course.setCourse_time(csvRow.get(0));
		course.setId(csvRow.get(1));
		course.setCourse_name(csvRow.get(2));
		course.setCourse_introduce(csvRow.get(3));
		course.setCourse_collect(csvRow.get(4));
		course.setCourse_apply(csvRow.get(5));
		course.setCourse_teacher(csvRow.get(6));
		course.setCourse_photo(csvRow.get(7));
		return course;
	}
	public static void main2(String[] args) throws IOException {
		CsvReader csvReader = CsvUtil.getReader();
		CsvData data = csvReader.read(FileUtil.file("C:\\Users\\Administrator\\Desktop\\练习\\course.csv"),
				CharsetUtil.CHARSET_GBK);
		List<CsvRow> rows = data.getRows();
		rows.remove(0);
		System.out.println(rows.get(1).get(0));
		for (CsvRow csvRow : rows) {
			System.out.println(csvRow.getRawList());
			Course course = new Course();
			course.setCourse_time(csvRow.get(0));
			course.setId(csvRow.get(1));
			course.setCourse_name(csvRow.get(2));
			course.setCourse_introduce(csvRow.get(3));
			course.setCourse_collect(csvRow.get(4));
			course.setCourse_apply(csvRow.get(5));
			course.setCourse_teacher(csvRow.get(6));
			course.setCourse_photo(csvRow.get(7));
		}

	}

	public static void main1(String[] args) {
		User user = new User();
		user.setId("id");
		user.setUser_per("学生");
		user.setUser_pwd("1234");
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user);
		String str = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(str);
	}
}
