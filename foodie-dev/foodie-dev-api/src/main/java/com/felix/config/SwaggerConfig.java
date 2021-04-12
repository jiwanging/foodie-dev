package com.felix.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
public class SwaggerConfig {

    public ApiInfo apiInfo(){
        return  new ApiInfoBuilder().
                title("天天吃货电商平台")
                .contact(new Contact("imooc",
                "https://www.imooc.com",
                "abc@imooc.com"))        // 联系人信息
                .description("专为天天吃货提供的api文档")  // 详细信息
                .version("1.0.1")   // 文档版本号
                .termsOfServiceUrl("https://www.imooc.com") // 网站地址
                .build();

    }
}
