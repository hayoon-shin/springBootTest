package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.project")
@ComponentScan(basePackages = {"com.project.controller","com.project.service","com.project.mapper","com.project.config"})
@MapperScan(basePackages = "com.project.mapper")
public class ImageShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageShopApplication.class, args);
	}

}
