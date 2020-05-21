package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.Ads;
import com.kaizhuo.tiangong.boot.support.core.mapper.AdsMapper;
import com.kaizhuo.tiangong.boot.support.core.service.IAdsService;
import org.springframework.stereotype.Service;

@Service
public class AdsServiceImpl extends BaseServiceImpl<AdsMapper, Ads> implements IAdsService {

}
