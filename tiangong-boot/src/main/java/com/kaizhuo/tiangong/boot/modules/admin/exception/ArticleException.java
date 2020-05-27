package com.kaizhuo.tiangong.boot.modules.admin.exception;


import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.modules.admin.constants.ArticleErrorCode;

public class ArticleException extends BaseException {

    public ArticleException(int status) {
        super(ArticleErrorCode.fromValue(status), status);
    }
}