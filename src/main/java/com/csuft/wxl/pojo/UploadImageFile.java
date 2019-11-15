package com.csuft.wxl.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageFile {
	MultipartFile image;

	public static String REAL_STUDENT_PATH="D:\\img\\student\\";
	public static String VIRT_STUDENT_PATH="/images/student/";
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
