package com.centime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.centime" })
public class Anime {

	public static void main(String[] args) {
		SpringApplication.run(Anime.class, args);
	}

}
