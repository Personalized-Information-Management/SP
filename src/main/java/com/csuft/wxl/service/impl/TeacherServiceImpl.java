package com.csuft.wxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.teacher.TCourseMap;
import com.csuft.wxl.map.teacher.TeacherMap;
import com.csuft.wxl.pojo.Course;
import com.csuft.wxl.pojo.Teacher;
import com.csuft.wxl.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TCourseMap tcoursemap;
	@Autowired
	TeacherMap teachermap;

	@Override
	public List<Course> getCourse(Teacher teacher) {
		// TODO Auto-generated method stub
		return tcoursemap.selectAllByTeacherId(teacher);
	}

	@Override
	public Teacher getIdAndPhoto(Teacher teacher) {
		// TODO Auto-generated method stub
		return teachermap.selectIdNamePhotoByTeacherId(teacher);
	}

}
