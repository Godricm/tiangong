package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Param;
import com.kaizhuo.tiangong.boot.modules.admin.service.IParamService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping("/v1/param")
@Api(value = "系统参数相关", tags = "系统参数相关")
public class ParamController extends BaseController<IParamService, Param> {

}

