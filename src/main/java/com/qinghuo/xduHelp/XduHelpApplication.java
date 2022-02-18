package com.qinghuo.xduHelp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qinghuo.xduHelp.mapper")
public class XduHelpApplication {
	public static void main(String[] args) {
		SpringApplication.run(XduHelpApplication.class, args);
	}
}
