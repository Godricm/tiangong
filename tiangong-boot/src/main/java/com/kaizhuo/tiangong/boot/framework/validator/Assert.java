package com.kaizhuo.tiangong.boot.framework.validator;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import org.apache.commons.lang.StringUtils;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.framework.validator
 * @description: 数据校验
 * @author: miaochen
 * @create: 2020-05-25 23:22
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BaseException(message, CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }
    }
}
