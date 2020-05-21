package com.kaizhuo.tiangong.boot.core.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:44
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
public class CollectionUtil {
    /**
     * 获取去除重复数据后的集合,根据泛型的hashCode以及equals方法判断是否为相同数据
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> List<T> distinctList(Collection<T> collection){
        if(CollectionUtils.isEmpty(collection)){
            return Collections.emptyList();
        }
        return collection.stream().distinct().collect(Collectors.toList());
    }
}
