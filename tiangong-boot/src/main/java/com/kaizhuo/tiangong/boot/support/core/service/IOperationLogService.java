package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.OperationLog;


public interface IOperationLogService extends BaseService<OperationLog> {
    void asyncSave(OperationLog log) throws InterruptedException;
}
