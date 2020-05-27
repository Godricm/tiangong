package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.TaskLog;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.TaskLogMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.ITaskLogService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskLogServiceImpl extends BaseServiceImpl<TaskLogMapper, TaskLog> implements ITaskLogService {
    @Override
    public List<TaskLog> list(Wrapper<TaskLog> queryWrapper) {
        return super.list(((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
    }

//    @Override
//    public IPage<TaskLog> page(IPage<TaskLog> page, Wrapper<TaskLog> queryWrapper) {
//        return super.page(page, ((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
//    }
}
