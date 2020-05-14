package com.kaizhuo.common.core.config;

import com.google.common.collect.Lists;
import com.kaizhuo.common.core.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.config
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 21:52
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kaizhuo"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey()));
    }

    private ApiKey apiKey() {
        return new ApiKey("jwt的token值", Constants.AUTHORIZATION, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
//                .securityReferences()
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
}
