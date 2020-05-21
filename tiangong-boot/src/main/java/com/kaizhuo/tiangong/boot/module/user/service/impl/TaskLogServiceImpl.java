package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.entity.TaskLog;
import com.kaizhuo.tiangong.boot.module.user.mapper.TaskLogMapper;
import com.kaizhuo.tiangong.boot.module.user.service.TaskLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:54
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class TaskLogServiceImpl extends BaseServiceImpl<TaskLogMapper, TaskLog> implements TaskLogService {
    @Override
    public List<TaskLog> list(Wrapper<TaskLog> queryWrapper) {
        return super.list(((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("create_time"));
    }
    @Override
    public IPage<TaskLog> page(IPage<TaskLog> page, Wrapper<TaskLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("create_time"));
    }

}
