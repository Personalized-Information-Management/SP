package com.csuft.wxl.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ViewResolverConfiguration {
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/"); // 这里我是在WEB-INF下有个jsp文件夹
		viewResolver.setSuffix(".jsp");
		viewResolver.setCache(false);
		viewResolver.setViewNames("jsp/*");
		viewResolver.setOrder(5);
		return viewResolver;

	}

}
