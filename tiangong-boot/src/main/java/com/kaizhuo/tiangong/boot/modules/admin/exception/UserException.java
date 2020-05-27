package com.kaizhuo.tiangong.boot.modules.admin.exception;


import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.modules.admin.constants.UserErrorCode;

public class UserException extends BaseException {

    public UserException(int status) {
        super(UserErrorCode.fromValue(status), status);
    }
}