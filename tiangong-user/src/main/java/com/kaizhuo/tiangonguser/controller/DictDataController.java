package com.kaizhuo.tiangonguser.controller;

import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.DictData;
import com.kaizhuo.tiangonguser.service.DictDataService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description: 字典数据相关
 * @author: miaochen
 * @create: 2020-05-18 21:08
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"dictData")
@Api(value = "字典数据相关",tags = "字典数据相关")
public class DictDataController extends BaseController<DictDataService, DictData> {
}
