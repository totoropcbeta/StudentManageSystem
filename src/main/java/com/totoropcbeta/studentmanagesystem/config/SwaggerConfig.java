package com.totoropcbeta.studentmanagesystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author yuanhang08
 * @date 2022年11月21日
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.java.userportraitsystem.controller"))
                .build()
                .apiInfo(createApiInfo());

    }

    /**
     * 配置swagger apiinfo bean
     */
    @Bean
    public ApiInfo createApiInfo() {
        Contact contact = new Contact("大脸猫", "http://localhost:8080/swagger-ui/", "957584602@qq.com");

        return new ApiInfoBuilder()
                .title("用户标签管理系统Demo")
                .description("用户标签管理系统接口文档")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
