package com.csuft.wxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.csuft.wxl.map")
public class SpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpApplication.class, args);
	}

}
