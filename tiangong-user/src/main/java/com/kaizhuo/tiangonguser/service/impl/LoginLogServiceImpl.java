package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.LoginLog;
import com.kaizhuo.tiangonguser.mapper.LoginLogMapper;
import com.kaizhuo.tiangonguser.service.LoginLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:18
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Override
    public List<LoginLog> list() {
        return super.list(new QueryWrapper<LoginLog>().orderByDesc("create_time"));
    }

    @Override
    public IPage<LoginLog> page(IPage<LoginLog> page, Wrapper<LoginLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<LoginLog>)queryWrapper).orderByDesc("create_time"));
    }
}
