package com.eshequ.crm.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.eshequ.crm"})
@MapperScan(basePackages="com.eshequ.crm.mapper")
@ComponentScan("com.eshequ.crm")
public class AppConfig {


	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
