package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Ads;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.AdsMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IAdsService;
import org.springframework.stereotype.Service;

@Service
public class AdsServiceImpl extends BaseServiceImpl<AdsMapper, Ads> implements IAdsService {

}
