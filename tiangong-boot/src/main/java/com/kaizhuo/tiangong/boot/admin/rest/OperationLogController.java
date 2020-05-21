package com.kaizhuo.tiangong.boot.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.support.core.entity.OperationLog;
import com.kaizhuo.tiangong.boot.support.core.service.IOperationLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/v1/operationLog")
@Api(value = "操作日志相关", tags = "操作日志相关")
public class OperationLogController extends BaseController<IOperationLogService, OperationLog> {

}

