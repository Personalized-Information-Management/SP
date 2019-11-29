package com.csuft.wxl.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageFile {
	MultipartFile image;

	public static String REAL_TEACHER_PATH="D:/img/teacher/";
	public static String REAL_STUDENT_PATH="D:/img/student/";
	public static String REAL_COURSE_PATH="D:/img/course/";
	
//	public static String REAL_TEACHER_PATH="/home/wxl/img/teacher/";
//	public static String REAL_STUDENT_PATH="/home/wxl/img/student/";
//	public static String REAL_COURSE_PATH="/home/wxl/img/course/";
	
	
	public static String VIRT_STUDENT_PATH="/images/student/";
	public static String VIRT_COURSE_PATH="/images/course/";
	public static String VIRT_TEACHER_PATH="/images/teacher/";
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
