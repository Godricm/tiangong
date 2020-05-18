package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.DictCatalog;
import com.kaizhuo.tiangonguser.service.DictCatalogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description: 字典目录信息相关
 * @author: miaochen
 * @create: 2020-05-17 22:19
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"dictCatalog")
@Api(value = "字典目录相关",tags = "字典目录相关")
public class DictCatalogController extends BaseController<DictCatalogService, DictCatalog> {
}
