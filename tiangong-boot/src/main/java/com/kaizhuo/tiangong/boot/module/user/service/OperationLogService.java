package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.OperationLog;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
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
