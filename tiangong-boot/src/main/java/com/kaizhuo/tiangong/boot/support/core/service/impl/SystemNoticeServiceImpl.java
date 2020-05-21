package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.SystemNotice;
import com.kaizhuo.tiangong.boot.support.core.mapper.SystemNoticeMapper;
import com.kaizhuo.tiangong.boot.support.core.service.ISystemNoticeService;
import org.springframework.stereotype.Service;

@Service
public class SystemNoticeServiceImpl extends BaseServiceImpl<SystemNoticeMapper, SystemNotice> implements ISystemNoticeService {

}
