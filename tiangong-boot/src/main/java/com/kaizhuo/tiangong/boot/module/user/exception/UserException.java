package com.kaizhuo.tiangong.boot.module.user.exception;

import com.kaizhuo.tiangong.boot.core.exception.BaseException;
import com.kaizhuo.tiangong.boot.module.user.constants.UserErrorCode;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 15:55
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
public class UserException extends BaseException {

    public UserException(int status) {
        super(UserErrorCode.fromValue(status), status);
    }
}
