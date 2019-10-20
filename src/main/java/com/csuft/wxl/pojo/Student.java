package com.csuft.wxl.pojo;

public class Student {
	String id;
	String student_name;
	String student_sex;
	String student_col;
	String student_majo;
	String student_phone;
	String seudent_photo;
	String student_per;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}
	public String getStudent_col() {
		return student_col;
	}
	public void setStudent_col(String student_col) {
		this.student_col = student_col;
	}
	public String getStudent_majo() {
		return student_majo;
	}
	public void setStudent_majo(String student_majo) {
		this.student_majo = student_majo;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getSeudent_photo() {
		return seudent_photo;
	}
	public void setSeudent_photo(String seudent_photo) {
		this.seudent_photo = seudent_photo;
	}
	public String getStudent_per() {
		return student_per;
	}
	public void setStudent_per(String student_per) {
		this.student_per = student_per;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", student_name=" + student_name + ", student_sex=" + student_sex
				+ ", student_col=" + student_col + ", student_majo=" + student_majo + ", student_phone=" + student_phone
				+ ", seudent_photo=" + seudent_photo + ", student_per=" + student_per + "]";
	}
	
}
