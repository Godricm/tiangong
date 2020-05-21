package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.TaskLog;
import com.kaizhuo.tiangong.boot.support.core.mapper.TaskLogMapper;
import com.kaizhuo.tiangong.boot.support.core.service.ITaskLogService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskLogServiceImpl extends BaseServiceImpl<TaskLogMapper, TaskLog> implements ITaskLogService {
    @Override
    public List<TaskLog> list(Wrapper<TaskLog> queryWrapper) {
        return super.list(((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
    }

    @Override
    public IPage<TaskLog> page(IPage<TaskLog> page, Wrapper<TaskLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
    }
}
