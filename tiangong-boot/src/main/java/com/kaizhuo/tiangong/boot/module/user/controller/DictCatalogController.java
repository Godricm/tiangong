package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.DictCatalog;
import com.kaizhuo.tiangong.boot.module.user.service.DictCatalogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
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
