package com.iotmars.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger文档
 *
 * @author xushaohua
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("上线日")
                .apiInfo(new ApiInfoBuilder().title("MCOOK-SOA")
                        .contact(new Contact("xushaohua", "", "m15515547083@163.com")).version("1.0").build())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 不显示错误的接口地址,错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any()).build();
    }
}
