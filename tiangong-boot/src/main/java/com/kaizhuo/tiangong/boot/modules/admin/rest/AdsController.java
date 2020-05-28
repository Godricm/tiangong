package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Ads;
import com.kaizhuo.tiangong.boot.modules.admin.service.IAdsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Urls.ROOT+"/ads")
@Api(value = "广告轮播相关", tags = "广告轮播相关")
public class AdsController extends BaseController<IAdsService, Ads> {

}

