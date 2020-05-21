package com.kaizhuo.tiangong.boot.core.log.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.log.builder
 * @description:
 * @author: miaochen
 * @create: 2020-05-14 20:52
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class GetterAndSetter {

    /**
     * 执行getXxx方法
     *
     * @param t
     * @param propertyName
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    protected static <T> Object invokeGetMethod(T t, String propertyName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //通过集合类中列举的属性，获取对应的getXxx()方法名
        String getMethodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        //通过方法名获取方法
        Method getMethod = t.getClass().getMethod(getMethodName);
        return getMethod.invoke(t);
    }

    /**
     * 执行setXXXX方法
     * @param t
     * @param propertyName
     * @param setValue
     * @param setValueClazz
     * @param <T>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    protected static <T> void invokeSetMethod(T t, String propertyName, Object setValue, Class setValueClazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        String getGetMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        //通过方法名获取方法
        Method setMethod = t.getClass().getMethod(getGetMethodName, setValueClazz);
        //执行方法获设置值
        setMethod.invoke(t,setValue);
    }
}
