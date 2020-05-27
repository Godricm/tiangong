package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.admin.entity.DictData;
import com.kaizhuo.tiangong.boot.modules.admin.service.IDictDataService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/dictData")
@Api(value = "字典数据相关", tags = "字典数据相关")
public class DictDataController extends BaseController<IDictDataService, DictData> {

}

