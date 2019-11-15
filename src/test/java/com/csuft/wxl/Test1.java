package com.csuft.wxl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Discuss;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.UploadImageFile;
import com.csuft.wxl.pojo.User;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

public class Test1 {
	public static void main9(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("error", "1");
		map.put("data", "1");
		String json=JSON.toJSONString(map);
		System.out.println(json);
	}
	public static void main8(String[] args) {
//		我的世界
//		<p>我的世界</p>
//		1
//		1
		Discuss discuss = new Discuss();
		discuss.setDis_auto("1");
		discuss.setDis_per("1");
		discuss.setDis_title("我的世界");
		discuss.setDis_content("<p>我的世界</p>");
		Date date = new Date();
		discuss.setDis_time(String.valueOf(date.getTime()));
		System.out.println(discuss.toString());

	}

	public static void main7(String[] args) {
		String str = null;
		System.out.println(str == null);
	}

	public static void main6() {
		// 数据库地址图片判断
		String str = ".png";
		String[] str2 = str.split(UploadImageFile.VIRT_STUDENT_PATH);
		if (!str2[str2.length - 1].equals("")) {
			String str3 = UploadImageFile.REAL_STUDENT_PATH + str2[str2.length - 1];
			System.out.println(str3);
			File file = new File(str3);
			if (file.exists()) {
				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
			}
		} else {
			System.out.println("文件不存在");
		}

//		System.out.println(str);
//		System.out.println(str1);
	}

	public static void main5() {
//		String name = RandomStringUtils.randomAlphanumeric(10);
		String str = "5Qz7AsCOrZ.png";
		File newFile = new File(UploadImageFile.REAL_STUDENT_PATH, str);
		if (newFile.exists()) {
			System.out.println("文件存在");
		} else {
			System.out.println("文件不存在");
		}
//		newFile.getParentFile().mkdirs();
//		file.getImage().transferTo(newFile);
//
//		m.addAttribute("imageName", "/images/student/"+newFileName);
	}

	public static void main4(String[] args) {
		int a = 1;
		String str = null;
		if (a == 1) {
			str = String.format("{str:'%s',photo:'%s'}", "修改成功", "img/成功.png");
		} else {
			str = String.format("{str:'%s',photo:'%s'}", "修改失败", "img/失败-01.png");
		}
		System.out.println(str);

	}

	public static void main2(String[] args) {
		Student student = new Student();
		System.out.println(String.format("{phote:%s,name:%s,phono:%s,col:%s,mar:%s}", student.getSeudent_photo(),
				student.getId(), student.getStudent_name(), student.getStudent_sex(), student.getStudent_col()));
	}

	public static void main12(String[] args) {
		Course course = getOne();
		System.out.println(course);
	}

	public static Course getOne() {
		CsvReader csvReader = CsvUtil.getReader();
		CsvData data = csvReader.read(FileUtil.file("C:\\Users\\Administrator\\Desktop\\练习\\course.csv"),
				CharsetUtil.CHARSET_GBK);
		List<CsvRow> rows = data.getRows();
		rows.remove(0);
		CsvRow csvRow = rows.get(0);
		Course course = new Course();
		course.setCourse_time(csvRow.get(0));
		course.setId(csvRow.get(1));
		course.setCourse_name(csvRow.get(2));
		course.setCourse_introduce(csvRow.get(3));
		course.setCourse_teacher(csvRow.get(6));
		course.setCourse_photo(csvRow.get(7));
		return course;
	}

	public static void main3(String[] args) throws IOException {
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
