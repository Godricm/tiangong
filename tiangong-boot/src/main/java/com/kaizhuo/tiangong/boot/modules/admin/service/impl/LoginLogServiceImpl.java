package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.LoginLog;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.LoginLogMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.ILoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {
    @Override
    public List<LoginLog> list(Wrapper<LoginLog> queryWrapper) {
        return super.list(((QueryWrapper<LoginLog>)queryWrapper).orderByDesc("ct"));
    }


//    @Override
//    public IPage<LoginLog> page(IPage<LoginLog> page, Wrapper<LoginLog> queryWrapper) {
//        return super.page(page, ((QueryWrapper<LoginLog>)queryWrapper).orderByDesc("ct"));
//    }
}
