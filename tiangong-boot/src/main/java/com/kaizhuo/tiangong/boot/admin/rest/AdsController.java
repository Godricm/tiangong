package com.kaizhuo.tiangong.boot.admin.rest;


import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.support.core.entity.Ads;
import com.kaizhuo.tiangong.boot.support.core.service.IAdsService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ads")
@Api(value = "广告轮播相关", tags = "广告轮播相关")
public class AdsController extends BaseController<IAdsService, Ads> {

}

