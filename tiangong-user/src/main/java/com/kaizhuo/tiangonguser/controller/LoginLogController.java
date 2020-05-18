package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.LoginLog;
import com.kaizhuo.tiangonguser.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description: 登录日志
 * @author: miaochen
 * @create: 2020-05-18 21:15
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT +"loginLog")
@Api(value = "登录日志相关", tags = "登录日志相关")
public class LoginLogController extends BaseController<LoginLogService, LoginLog> {

}
