package com.felix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
@EnableSwagger2
public class ApiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSpringApplication.class);
    }
}
