package com.csuft.wxl.pojo;

public class Teacher {
	String id;
	String teacher_name;
	String teacher_sex;
	String teacher_birth;
	String teacher_photo;
	String teacher_phone;
	String teacher_per;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_sex() {
		return teacher_sex;
	}

	public void setTeacher_sex(String teacher_sex) {
		this.teacher_sex = teacher_sex;
	}

	public String getTeacher_birth() {
		return teacher_birth;
	}

	public void setTeacher_birth(String teacher_birth) {
		this.teacher_birth = teacher_birth;
	}

	public String getTeacher_photo() {
		return teacher_photo;
	}

	public void setTeacher_photo(String teacher_photo) {
		this.teacher_photo = teacher_photo;
	}

	public String getTeacher_phone() {
		return teacher_phone;
	}

	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}

	public String getTeacher_per() {
		return teacher_per;
	}

	public void setTeacher_per(String teacher_per) {
		this.teacher_per = teacher_per;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacher_name=" + teacher_name + ", teacher_sex=" + teacher_sex
				+ ", teacher_birth=" + teacher_birth + ", teacher_photo=" + teacher_photo + ", teacher_phone="
				+ teacher_phone + ", teacher_per=" + teacher_per + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
