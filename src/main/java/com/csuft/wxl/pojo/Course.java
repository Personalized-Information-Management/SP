package com.csuft.wxl.pojo;

import java.util.List;

public class Course {
	String id;// 课程编号
	String course_name;// 课程名
	String course_introduce;// 课程介绍
	String course_photo;// 课程相片
	String course_teacher;// 课程教师

	String course_time;// 开课时间
	String course_hour;
	String course_teacher_name;

	String study;
	String collect;

	String course_folder;
	// 课程状态，1在编辑
	String course_state;
	String course_content;
	
	List<Notice> notices;

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public String getCourse_state() {
		return course_state;
	}

	public void setCourse_state(String course_state) {
		this.course_state = course_state;
	}

	public String getCourse_folder() {
		return course_folder;
	}

	public void setCourse_folder(String course_folder) {
		this.course_folder = course_folder;
	}

	public String getCourse_content() {
		return course_content;
	}

	public void setCourse_content(String course_content) {
		this.course_content = course_content;
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	public String getCollect() {
		return collect;
	}

	public void setCollect(String collect) {
		this.collect = collect;
	}

	public String getCourse_teacher_name() {
		return course_teacher_name;
	}

	public String getCourse_hour() {
		return course_hour;
	}

	public void setCourse_hour(String course_hour) {
		this.course_hour = course_hour;
	}

	public void setCourse_teacher_name(String course_teacher_name) {
		this.course_teacher_name = course_teacher_name;
	}

	public String getId() {
		return id;
	}

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	public String getCourse_time() {
		return course_time;
	}

	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_introduce() {
		return course_introduce;
	}

	public void setCourse_introduce(String course_introduce) {
		this.course_introduce = course_introduce;
	}

	public String getCourse_photo() {
		return course_photo;
	}

	public void setCourse_photo(String course_photo) {
		this.course_photo = course_photo;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", course_introduce=" + course_introduce
				+ ", course_photo=" + course_photo + ", course_teacher=" + course_teacher + ", course_time="
				+ course_time + ", course_hour=" + course_hour + ", course_teacher_name=" + course_teacher_name
				+ ", study=" + study + ", collect=" + collect + ", course_folder=" + course_folder + ", course_state="
				+ course_state + ", course_content=" + course_content + ", notices=" + notices + "]";
	}

}
