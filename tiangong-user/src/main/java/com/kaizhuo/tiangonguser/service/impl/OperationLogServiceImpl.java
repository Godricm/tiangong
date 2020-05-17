package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.OperationLog;
import com.kaizhuo.tiangonguser.entity.User;
import com.kaizhuo.tiangonguser.mapper.OperationLogMapper;
import com.kaizhuo.tiangonguser.service.OperationLogService;
import com.kaizhuo.tiangonguser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:20
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class OperationLogServiceImpl extends BaseServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
    @Autowired
    private UserService userService;

    @Override
    public void asyncSave(OperationLog log) throws InterruptedException {
        Long userId = log.getUserId();
        if(userId != null){
            User userInfo = userService.getById(userId);
            log.setUsername(userInfo.getUserName());
        }
        save(log);
    }

    @Override
    public List<OperationLog> list() {
        return super.list(new QueryWrapper<OperationLog>().orderByDesc("create_time"));
    }

    @Override
    public IPage<OperationLog> page(IPage<OperationLog> page, Wrapper<OperationLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<OperationLog>)queryWrapper).orderByDesc("create_time"));
    }
}
