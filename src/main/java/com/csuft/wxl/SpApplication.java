package com.csuft.wxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 请看看com.csuft.wxl.controller.teacher.TCourseController.name5(HttpServletRequest, HttpServletResponse, UploadImageFile)中的图片路径的请求地址
 * @author wxljllm
 *
 */

@SpringBootApplication
@MapperScan("com.csuft.wxl.map")
public class SpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpApplication.class, args);
	}
	

}
