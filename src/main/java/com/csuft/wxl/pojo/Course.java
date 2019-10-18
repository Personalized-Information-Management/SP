package com.csuft.wxl.pojo;

public class Course {
	String id;//课程编号
	String course_name;//课程名
	String course_introduce;//课程介绍
	String course_collect;//课程收藏人数
	String course_photo;//课程相片
	String course_apply;//课程学习人数
	String course_teacher;//课程教师
	String course_time;//开课时间

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

	public String getCourse_collect() {
		return course_collect;
	}

	public void setCourse_collect(String course_collect) {
		this.course_collect = course_collect;
	}

	public String getCourse_photo() {
		return course_photo;
	}

	public void setCourse_photo(String course_photo) {
		this.course_photo = course_photo;
	}

	public String getCourse_apply() {
		return course_apply;
	}

	public void setCourse_apply(String course_apply) {
		this.course_apply = course_apply;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", course_introduce=" + course_introduce
				+ ", course_collect=" + course_collect + ", course_photo=" + course_photo + ", course_apply="
				+ course_apply + ", course_teacher=" + course_teacher + ", course_time=" + course_time + "]";
	}

	

}
