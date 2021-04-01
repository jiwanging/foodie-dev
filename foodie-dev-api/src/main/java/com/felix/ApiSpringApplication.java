package com.felix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
public class ApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSpringApplication.class);
    }
}
