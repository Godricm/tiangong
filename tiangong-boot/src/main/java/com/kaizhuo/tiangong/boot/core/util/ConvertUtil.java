package com.kaizhuo.tiangong.boot.core.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;;
import org.apache.commons.beanutils.ConvertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.core.util
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 22:14
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class ConvertUtil {
    public static List<Long> splitStr2LongList(String content, String splitChar) {
        if(StringUtils.isEmpty(content)){
            return new ArrayList<>();
        }

        String[] split = content.split(splitChar);
        Long[] longArr = (Long[]) ConvertUtils.convert(split, Long.class);
        // 返回值类型是ArrayList，但此ArrayList是Array的内部类,调用add()时，会报错：java.lang.UnsupportedOperationException;故需要再次构造一个新的ArrayList
        return new ArrayList<>(Arrays.asList(longArr));
    }

    public static String[] splitStr2StrArray(String content, String splitChar) {
        if(StringUtils.isEmpty(content)){
            return new String[]{};
        }

        String[] split = content.split(splitChar);
        return split;
    }

    public static <T, S> List<T> convertList(List<S> sourceList, Class<T> targetClazz){
        if(CollectionUtils.isEmpty(sourceList)){
            return new ArrayList<>();
        }

        return JSON.parseArray(JSON.toJSONString(sourceList), targetClazz);
    }
}
