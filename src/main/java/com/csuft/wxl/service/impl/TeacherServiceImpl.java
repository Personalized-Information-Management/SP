package com.csuft.wxl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csuft.wxl.map.teacher.TCourseMap;
import com.csuft.wxl.map.teacher.TNoticeMap;
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
	@Autowired
	TNoticeMap tnoticemap;

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

	@Override
	public int getCourse_count(Teacher teacher) {
		// TODO Auto-generated method stub
		return tcoursemap.selectAllByTeacherId_count(teacher);
	}

	@Override
	public List<Course> getNoticesByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int num = tnoticemap.selectNoticeByTeacher_count(teacher);
		if (num != 0) {
			return tnoticemap.selectNoticeByTeacher(teacher);
		} else {
			List<Course> list = new ArrayList<Course>();
			return list;
		}

	}

}
