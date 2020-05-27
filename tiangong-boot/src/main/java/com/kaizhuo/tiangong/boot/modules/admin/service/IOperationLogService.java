package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.OperationLog;


public interface IOperationLogService extends BaseService<OperationLog> {
    void asyncSave(OperationLog log) throws InterruptedException;
}
