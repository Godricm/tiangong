package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.SystemNotice;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.SystemNoticeMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.ISystemNoticeService;
import org.springframework.stereotype.Service;

@Service
public class SystemNoticeServiceImpl extends BaseServiceImpl<SystemNoticeMapper, SystemNotice> implements ISystemNoticeService {

}
