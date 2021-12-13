package com.xinchao.fries_community_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@MapperScan("com.xinchao.fries_community_backend.mapper")
@SpringBootApplication
public class FriesCommunityBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FriesCommunityBackendApplication.class, args);
    }

}
