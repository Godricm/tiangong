package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.OperationLog;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 操作日志服务
 * @author: miaochen
 * @create: 2020-05-15 23:30
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface OperationLogService extends BaseService<OperationLog> {
    void asyncSave(OperationLog log) throws InterruptedException;
}
