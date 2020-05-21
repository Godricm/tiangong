package com.kaizhuo.tiangong.boot.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.kaizhuo.tiangong.boot.**.mapper")
public class ApplicationConfig {

}
