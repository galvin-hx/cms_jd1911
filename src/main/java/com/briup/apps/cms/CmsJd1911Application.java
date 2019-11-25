package com.briup.apps.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan({"com.briup.apps.cms.dao"})
@SpringBootApplication
public class CmsJd1911Application extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CmsJd1911Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CmsJd1911Application.class, args);
	}
}
