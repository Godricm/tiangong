package com.kaizhuo.tiangong.boot.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.support.core.entity.DictCatalog;
import com.kaizhuo.tiangong.boot.support.core.service.IDictCatalogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/dictCatalog")
@Api(value = "字典目录相关", tags = "字典目录相关")
public class DictCatalogController extends BaseController<IDictCatalogService, DictCatalog> {

}

