package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.Param;
import com.kaizhuo.tiangong.boot.module.user.service.ParamService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
 * @description: 系统参数相关
 * @author: miaochen
 * @create: 2020-05-18 21:18
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT + "param")
@Api(value = "系统参数相关", tags = "系统参数相关")
public class ParamController extends BaseController<ParamService, Param> {
}
