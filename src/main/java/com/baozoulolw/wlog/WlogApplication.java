package com.baozoulolw.wlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.baozoulolw.wlog.dao"})
@SpringBootApplication
public class WlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlogApplication.class, args);
	}

}
