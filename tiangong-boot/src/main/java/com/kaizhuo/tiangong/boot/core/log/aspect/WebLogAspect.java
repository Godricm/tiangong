package com.kaizhuo.tiangong.boot.core.log.aspect;

import com.alibaba.fastjson.JSON;
import com.kaizhuo.tiangong.boot.core.util.NetworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.log.aspect
 * @description: 自定义日志输出。仅输出controller包下相关controller的请求和返回内容日志，方便调试。
 * @author: miaochen
 * @create: 2020-05-13 23:09
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public !void *..controller..*.*(..))")
    public void webLog() {
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        String headers = JSON.toJSONString(headerNames);

        String queryString = request.getQueryString();

        StringBuilder params = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object obj : args) {
                if (obj != null) {
                    if(obj instanceof MultipartFile){
                        params.append(String.format("上传文件,名称%s,文件大小%d", ((MultipartFile) obj).getOriginalFilename(), ((MultipartFile) obj).getSize()));
                    }else{
                        params.append(JSON.toJSONString(obj));
                    }
                    params.append(",");
                }
            }
        }

        // 记录下请求内容
        log.info("-------------请求信息开始--------------");
        log.info(String.format("发起请求的IP:%1$s", NetworkUtils.getIpAddr(request)));
        log.info(String.format("请求Url:%1$s", request.getRequestURL().toString()));
        log.info(String.format("请求方式:%1$s", request.getMethod()));
        log.info(String.format("请求头:%1$s", headers));
        log.info(String.format("请求参数:%1$s", params.toString()));
        log.info("-------------请求信息结束--------------");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 记录下响应内容
        log.info("-------------响应信息开始--------------");
        log.info(String.format("response info: %1$s ",
                JSON.toJSONString(ret)
        ));
        log.info("-------------响应信息结束--------------");
        log.info("===================================================");
    }
}
