package com.csuft.wxl.service;

import com.csuft.wxl.pojo.Student;

public interface StudentService {
	public Student getStudentStudysCourse(Student student);

	public int getStudentStudysCourse_count(Student student);

	public Student getStudentCollectCourse(Student student);
	public int getStudentCollectCourse_count(Student student);

	public Student getStudentFinishCourse(Student student);

	public int getStudentFinishCourse_count(Student student);

	public Student getStudent(Student student);

	public int modifyStudnt(Student student);

	public int modifyStudntPhoto(Student student);

}
