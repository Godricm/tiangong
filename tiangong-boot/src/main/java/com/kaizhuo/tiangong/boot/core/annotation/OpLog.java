package com.kaizhuo.tiangong.boot.core.annotation;


import java.lang.annotation.*;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.annotation
 * @description: 操作日志
 * @author: miaochen
 * @create: 2020-05-19 23:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {
    String description()  default "";
    OpType opType() default OpType.OTHER;
    boolean isSaveParams() default true;
}