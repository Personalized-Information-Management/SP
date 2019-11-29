package com.csuft.wxl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csuft.wxl.map.CourseMap;
import com.csuft.wxl.map.DiscussMap;
import com.csuft.wxl.map.NoticeMap;
import com.csuft.wxl.map.StudentMap;
import com.csuft.wxl.map.UserMap;
import com.csuft.wxl.map.teacher.TCourseMap;
import com.csuft.wxl.map.teacher.TNoticeMap;
import com.csuft.wxl.map.teacher.TeacherMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Discuss;
import com.csuft.wxl.pojo.Notice;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.pojo.UploadImageFile;
import com.csuft.wxl.pojo.User;
import com.csuft.wxl.service.CourseService;
import com.csuft.wxl.service.DiscussService;
import com.csuft.wxl.service.NoticeService;
import com.csuft.wxl.service.StudentService;
import com.csuft.wxl.service.TeacherService;
import com.csuft.wxl.service.UserService;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

//修改数据库密码，用户
//修改资源映射路径

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

	@Autowired
	StudentService studentService;

	@Autowired
	StudentMap studentMap;
	@Autowired
	DiscussService discussService;

	@Autowired
	DiscussMap discussMap;
	@Autowired
	NoticeMap noticeMap;
	@Autowired
	NoticeService noticeService;

	@Autowired
	TCourseMap tcoursemap;
	@Autowired
	TeacherService teacherservice;
	@Autowired
	TNoticeMap tnoticemap;
	@Autowired
	TeacherMap teachermap;

	@Test
	public void name32() {
		Student student = new Student();
		student.setId("1");
		List<Course> course = noticeMap.selectNoticeByStudent_id(student);
		String json = JSON.toJSONString(course, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name31() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		String pwd = teachermap.selectPwd(teacher);
		System.out.println("修改前" + pwd);
		Map<String, String> map = new HashMap<String, String>();
		map.put("pwd", "1234");
		map.put("id", "1");
		int num = teachermap.updatePwd(map);
		String pwd1 = teachermap.selectPwd(teacher);
		System.out.println("修改后" + pwd1);

	}

//	@Test
	public void name30() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
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
		System.out.println(newFile.getPath());

//		String json = JSON.toJSONString(teacher, SerializerFeature.WriteMapNullValue);
//		System.out.println(json);
	}

//	@Test
	public void name29() {
		Notice notice = new Notice();
		notice.setNotice_courseid("1");
		notice.setNotice_content("hello world");
		Date date = new Date();
		notice.setNotice_time(String.valueOf(date.getTime()));
		int num = tnoticemap.insertOneNotice(notice);
		System.out.println("插入的消息的条数：" + num);
	}

//@Test
	public void name28() {
		Course course = new Course();
		course.setId("1");
		course = tcoursemap.selectCourseByCourseId(course);
		String json = JSON.toJSONString(course, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

	// 发布的所有课程
//	@Test
	public void name27() {
		Course course = new Course();
		course.setId("1");

		course = courseService.getDetails(course);
		String str1 = courseService.getCollect(course);
		String str2 = courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);

		Course course1 = new Course();
		course1.setId("1");
		course1 = courseService.getContent(course1);
		String json1 = JSON.toJSONString(course1, SerializerFeature.WriteMapNullValue);
		System.out.println("data" + json);
		System.out.println("data1" + json1);
	}

//	@Test
	public void name26() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		int num = teacherservice.getCourse_count(teacher);
		if (num != 0) {
			List<Course> list = teacherservice.getCourse(teacher);
			String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(json);
		} else {
			System.out.println("未发布课程");
		}
	}

//	@Test
	public void name25() {
		Teacher teacher = new Teacher();
		teacher.setId("2");
		List<Course> list = teacherservice.getNoticesByTeacher(teacher);

		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name24() {
		Student student = new Student();
		student.setId("1");
		// num
		int num = noticeService.getNotic_count(student);
		if (num != 0) {
			student = noticeService.getNotice(student);

			System.out.println(student);

			List<Course> list = new ArrayList<Course>();
			for (Notice notice : student.getNotices()) {
				Course course = new Course();
				// 获取id 和课程名
				System.out.println(notice);
				int num1 = courseService.getCourseByNotice_count(notice);
				if (num1 == 1) {
					course = courseService.getCourseByNotice(notice);
				} else {
					course.setId("");
				}
				list.add(course);
			}
			student.setCourse(list);
			List<Map> list1 = new ArrayList<Map>();
			// 消息存在，通过课程判断
			for (int i = 0; i < student.getCourse().size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				if (student.getCourse().get(i).getId().equals("")) {
					continue;
				}
				map.put("courses", student.getCourse().get(i));
				map.put("notices", student.getNotices().get(i));
				list1.add(map);
			}
			String json = JSON.toJSONString(list1, SerializerFeature.WriteMapNullValue);
			System.out.println(json);
		}

	}

//	@Test
	public void name23() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		List<Course> list = teacherservice.getCourse(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		System.out.println(json);

	}

//	@Test
	public void name22() {
		Course course = new Course();
		course.setId("1");
		course = courseService.getContent(course);
		System.out.println(course.toString());
	}

//	@Test
	public void name21() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		teacher = teacherservice.getIdAndPhoto(teacher);
		System.out.println(teacher.toString());
	}

//	@Test
	public void name20() {
		Course course = new Course();
		course.setCourse_name("数学");
		course.setCourse_introduce("这是数学课");
		Date date = new Date();
		course.setCourse_time(String.valueOf(date.getTime()));
		course.setCourse_teacher("1");
		course.setCourse_folder("///fqwef//qwef");
		course.setCourse_photo("/f/f/eqw");
		int a = courseMap.insertReturnId(course);
		System.out.println(a);
		System.out.println(course.getId());
	}

//	@Test
	public void name19() {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		List<Course> list = tcoursemap.selectAllByTeacherId(teacher);
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		System.out.println(json);

	}

//	@Test
	public void name18() {

		List<Notice> list = noticeMap.selectNoticeStateById();
		for (Notice notice : list) {
			String json = JSON.toJSONString(notice, SerializerFeature.WriteMapNullValue);
			System.out.println(json);
		}
	}

//	@Test
	public void name17() {
		// 获取一个学生的所有课程通知
		Student student = new Student();
		student.setId("1");
		student = noticeService.getNotice(student);
		List<Course> list = new ArrayList<Course>();
		for (Notice notice : student.getNotices()) {
			Course course = new Course();
			course = courseService.getCourseByNotice(notice);
			list.add(course);
		}
		student.setCourse(list);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name16() {
		Student student = new Student();
		student.setId("1");
		student = noticeMap.selectNotice(student);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name15() {
		Discuss discuss = new Discuss();
		discuss.setDis_auto("1");
		discuss.setDis_per("1");
		discuss.setDis_title("我的世界");
		discuss.setDis_content("<p>我的世界</p>");
		Date date = new Date();
		discuss.setDis_time(String.valueOf(date.getTime()));
		System.out.println(discuss.toString());
		int a = discussService.setDis(discuss);
		System.out.println("\n\n\n");
		if (a == 1) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
		System.out.println("\n\n\n");
	}

//	@Test
	public void name14() {
		List<Discuss> list = discussMap.selectAllDisAndAuthor();
		String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
		Student student = new Student();
		student.setId("1");
		student.setStudent_per("1");
		student = studentService.getStudent(student);
		System.out.println();
		System.out.println(student);
		System.out.println();
		System.out.println(json);
		System.out.println();
	}

//	@Test
	public void name13() {
		Student student = new Student();
		student.setId("1");
		student = studentService.getStudent(student);
		if (student.getSeudent_photo() != null) {
			String str = student.getSeudent_photo();
			String[] str2 = str.split(UploadImageFile.VIRT_STUDENT_PATH);
			if (!str2[str2.length - 1].equals("")) {
				String str3 = UploadImageFile.REAL_STUDENT_PATH + str2[str2.length - 1];
				System.out.println("str3" + str3);
				File file = new File(str3);
				if (file.exists()) {
					System.out.println("文件存在");
				} else {
					System.out.println("文件不存在");
				}

			} else {
				System.out.println("文件不存在");
			}
		} else {
			System.out.println("文件不存在");
		}

	}

//	@Test
	public void name12() {
		Student student = new Student();
		student.setId("1");
		student.setStudent_name("王五");
		student.setStudent_sex("男");
		student.setStudent_phone("123456789");
		student.setStudent_col("商学院");
		student.setStudent_majo("生命科学");
		int a = studentService.modifyStudnt(student);
		if (a == 1) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}

	}

//	@Test
	public void name11() {
		Student student = new Student();
		student.setId("1");
		student = studentService.getStudent(student);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name10() {
		Student student = new Student();
		student.setId("1");
		student = studentMap.selectStudentById(student);
		String json = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
		System.out.println(json);
	}

//	@Test
	public void name9() {
		Course course = new Course();
		course.setId("93");
		course = courseService.getDetails(course);
		String str1 = courseService.getCollect(course);
		String str2 = courseService.getStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

//	@Test
	public void name8() {
		Course course = new Course();
		course.setId("1");
		course = courseService.getDetails(course);
		String str1 = courseMap.selectCourseCollect(course);
		String str2 = courseMap.selectCourseStudy(course);
		course.setCollect(str1);
		course.setStudy(str2);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

//	@Test
	public void name7() {
		Course course = new Course();
		course.setId("1");
		course = courseMap.selectCollect(course);
		String json = JSON.toJSONString(course, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

//	@Test
	public void name6() {
		Student student = new Student();
		student.setId("1");
		student = studentMap.selectCollectCourseById(student);
		System.out.println(student.getCourse().size());
		List<Course> list = student.getCourse();
		for (Course course : list) {
			System.out.println(course.toString());
		}
	}

//	@Test
	public void name5() {
		Student student = new Student();
		student.setId("1");
		student = studentService.getStudentStudysCourse(student);
		String json = JSON.toJSONString(student.getCourse(), SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

//	@Test
	public void name4() {
		Student student = new Student();
		student.setId("1");
		Student student1 = studentMap.selecStudyCourse(student);
		System.out.println(student1.toString());

	}

//	@Test
	public void name3() {
		List<Course> list = courseService.getAllListPart();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
	}

//	@Test
	public void name2() {
		List<Course> list = courseService.getAllList();
		String json = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(json);
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
