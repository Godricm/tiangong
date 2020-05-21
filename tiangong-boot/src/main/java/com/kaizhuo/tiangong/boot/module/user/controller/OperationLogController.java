package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.OperationLog;
import com.kaizhuo.tiangong.boot.module.user.service.OperationLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
 * @description: 操作日志相关
 * @author: miaochen
 * @create: 2020-05-18 21:16
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"operationLog")
@Api(value = "操作日志相关",tags = "操作日志相关")
public class OperationLogController extends BaseController<OperationLogService, OperationLog> {
}
