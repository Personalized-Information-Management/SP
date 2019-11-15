package com.csuft.wxl.pojo;

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
				+ ", study=" + study + ", collect=" + collect + "]";
	}

}
