package com.kaizhuo.tiangong.boot.support.core.exception;


import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.support.core.constants.UserErrorCode;

public class UserException extends BaseException {

    public UserException(int status) {
        super(UserErrorCode.fromValue(status), status);
    }
}