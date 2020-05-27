package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.admin.entity.LoginLog;
import com.kaizhuo.tiangong.boot.modules.admin.service.ILoginLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/loginLog")
@Api(value = "登录日志相关", tags = "登录日志相关")
public class LoginLogController extends BaseController<ILoginLogService, LoginLog> {

}

