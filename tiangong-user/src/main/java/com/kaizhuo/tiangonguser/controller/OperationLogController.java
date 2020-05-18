package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.OperationLog;
import com.kaizhuo.tiangonguser.service.OperationLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
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
