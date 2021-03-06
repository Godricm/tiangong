package com.kaizhuo.tiangong.boot.modules.quartz.exception;

import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.modules.quartz.constants.TaskErrorCode;

public class TaskException extends BaseException {

    public TaskException(int status) {
        super(TaskErrorCode.fromValue(status), status);
    }
}