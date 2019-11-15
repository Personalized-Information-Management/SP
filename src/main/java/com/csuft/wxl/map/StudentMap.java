package com.csuft.wxl.map;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Student;

@Mapper
public interface StudentMap {
	// 更具学生id获取学习的课程id,名字，图片和教师，
	public Student selecStudyCourse(Student student);
	//获取收藏
	public Student selectCollectCourseById(Student student);
	//获取完成课程
	public Student selectFinishCourseById(Student student);
	//获取学生的所有信息
	public Student selectStudentById(Student student);
	
	public int updateStudentById(Student student);
	//只更新图片路径
	public int updateStudentPhotoById(Student student);
}
