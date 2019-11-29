package com.csuft.wxl.map.teacher;

import java.util.Map;

import com.csuft.wxl.pojo.Teacher;

public interface TeacherMap {
	public Teacher selectIdNamePhotoByTeacherId(Teacher teacher);

	// 传入id,获取教师的信息
	public Teacher selectTeacherById(Teacher teacher);

	// 仅仅修改教师图片
	public int updateTeacherPhone(Teacher teacher);

	// 修改教师
	public int updateTeacher(Teacher teacher);

	// 获取密码
	public String selectPwd(Teacher teacher);
	
	//修改密码pwd 和id
	public int updatePwd(Map<String, String> map);
}
