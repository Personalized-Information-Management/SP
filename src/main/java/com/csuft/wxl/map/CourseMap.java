package com.csuft.wxl.map;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Notice;

@Mapper
public interface CourseMap {
	public int insertOne(Course course);

	public List<Course> selectAll();

	public List<Course> selectAllIdTeacherName();

	public int selectAllIdTeacherName_count();

	// 查询有错
	public Course selectCollect(Course course);

	public String selectCourseCollect(Course course);

	public String selectCourseStudy(Course course);

	// 根据消息课程获取课程名
	public Course selectCourseRetuenCourseidCourseName(Notice notice);

	// 判断消息对应的课程是否存在 返回值0或1
	public int selectCourseRetuenCourseidCourseName_conut(Notice notice);

	// 插入5个课程属性
	public int insertReturnId(Course course);

	// 更具id获取文件夹路径
	public String selectPathById(Course course);

	// 根据id设置课程内容
	public int insertContentByid(Course course);

	// 判断课程学生记录是否存在
	public int selectCollentExist(Map<String, String> map);

	// 插入学生id,课程id到学生课程表
	public int insertOneStudent_idCourse_id(Map<String, String> map);

	public int updateCollectByStudetnCourse(Map<String, String> map);

	// 获取课程内容
	public Course selectCourseContentById(Course course);

	public int insertOneStudyStudent_idCourse_id(Map<String, String> map);

	public int updateStudyByStudetnCourse(Map<String, String> map);

	public int updateStudytoNull(Map<String, String> map);

	public int updateCollecttoNull(Map<String, String> map);

}
