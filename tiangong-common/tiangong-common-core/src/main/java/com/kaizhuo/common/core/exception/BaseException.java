package com.kaizhuo.common.core.exception;

import com.kaizhuo.common.core.enums.CoreErrorCode;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.exception
 * @description: 全局异常
 * @author: miaochen
 * @create: 2020-05-03 18:35
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public class BaseException extends RuntimeException {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BaseException() {
        this(CoreErrorCode.SYSTEM_ERROR.getCode());
    }

    public BaseException(int status) {
        this(CoreErrorCode.fromValue(status), status);
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }
}
