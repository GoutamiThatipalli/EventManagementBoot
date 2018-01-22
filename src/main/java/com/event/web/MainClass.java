package com.event.web;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.event.service.StorageService;

@SpringBootApplication
@ComponentScan("com.event")
public class MainClass {
	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
	}
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}

