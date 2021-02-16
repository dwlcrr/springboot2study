package com.atguigu.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式，例如，基于包名
                .apis(RequestHandlerSelectors.basePackage("com.atguigu.admin.controller"))
                .build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        return new ApiInfo("web-admin的api文档",
                "学习springboot开发后端框架",
                "1.0",
                "www.jd.com",
                new Contact("123", "www.baidu.com", "123@456.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
