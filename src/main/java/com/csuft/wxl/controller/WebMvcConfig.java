package com.csuft.wxl.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 资源目录course->课程
		// 资源目录student->学生
		// 资源目录teacher->教师
		registry.addResourceHandler("/images/course/**").addResourceLocations("file:D:\\img\\course\\");
		registry.addResourceHandler("/images/student/**").addResourceLocations("file:D:\\img\\student\\");
		registry.addResourceHandler("/images/teacher/**").addResourceLocations("file:D:\\img\\teacher\\");
		registry.addResourceHandler("/images/dis/**").addResourceLocations("file:D:\\img\\dis\\");
		registry.addResourceHandler("/Umeditor/image/dis/**").addResourceLocations("file:D:\\img\\dis\\");

//		registry.addResourceHandler("/images/course/**").addResourceLocations("file:/home/wxl/img/course/");
//		registry.addResourceHandler("/images/student/**").addResourceLocations("file:/home/wxl/img/student/");
//		registry.addResourceHandler("/images/teacher/**").addResourceLocations("file:/home/wxl/img/teacher/");
//		registry.addResourceHandler("/images/dis/**").addResourceLocations("file:/home/wxl/img/dis/");
//		registry.addResourceHandler("/Umeditor/image/dis/**").addResourceLocations("file:/home/wxl/img/dis/");
	}

}
