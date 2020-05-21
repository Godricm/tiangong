package com.kaizhuo.tiangong.boot.auth.exception;


import com.kaizhuo.tiangong.boot.auth.constants.AuthErrorCode;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;

public class AuthException extends BaseException {

    public AuthException(int status) {
        super(AuthErrorCode.fromValue(status), status);
    }
}