package com.kaizhuo.tiangonguser.exception;

import com.kaizhuo.common.core.exception.BaseException;
import com.kaizhuo.tiangonguser.constants.SystemErrorCode;
import com.kaizhuo.tiangonguser.constants.UserErrorCode;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:23
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
public class SystemException extends BaseException {
    public SystemException(int status) {
        super(SystemErrorCode.fromValue(status), status);
    }
}
