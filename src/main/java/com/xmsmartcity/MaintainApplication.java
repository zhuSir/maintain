package com.xmsmartcity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.xmsmartcity.mapper","com.xmsmartcity.leeModules.mapper"})
public class MaintainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintainApplication.class, args);
	}
}
