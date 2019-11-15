package com.csuft.wxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.StudentMap;
import com.csuft.wxl.pojo.Student;
import com.csuft.wxl.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentMap studentmap;
	//获取一个学生的课程
	@Override
	public Student getStudentStudysCourse(Student student) {
		// TODO Auto-generated method stub
		return studentmap.selecStudyCourse(student);
	}
	@Override
	public Student getStudentCollectCourse(Student student) {
		// TODO Auto-generated method stub
		return studentmap.selectCollectCourseById(student);
	}
	@Override
	public Student getStudentFinishCourse(Student student) {
		// TODO Auto-generated method stub
		return studentmap.selectFinishCourseById(student);
	}
	@Override
	public Student getStudent(Student student) {
		// TODO Auto-generated method stub
		return studentmap.selectStudentById(student);
	}
	@Override
	public int modifyStudnt(Student student) {
		// TODO Auto-generated method stub
		return studentmap.updateStudentById(student);
	}
	@Override
	public int modifyStudntPhoto(Student student) {
		// TODO Auto-generated method stub
		return studentmap.updateStudentPhotoById(student);
	}
	
}
