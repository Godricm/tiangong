package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.LoginLog;
import com.kaizhuo.tiangong.boot.module.user.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
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
