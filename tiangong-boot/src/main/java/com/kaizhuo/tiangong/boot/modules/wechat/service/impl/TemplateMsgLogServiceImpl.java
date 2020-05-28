package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.wechat.mapper.TemplateMsgLogMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.TemplateMsgLog;
import com.kaizhuo.tiangong.boot.modules.wechat.service.TemplateMsgLogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TemplateMsgLogServiceImpl extends BaseServiceImpl<TemplateMsgLogMapper, TemplateMsgLog> implements TemplateMsgLogService {

    /**
     * 未保存的队列
     */
    private static ConcurrentLinkedQueue<TemplateMsgLog> logsQueue = new ConcurrentLinkedQueue<>();

    /**
     * 添加访问log到队列中，队列数据会定时批量插入到数据库
     *
     * @param log
     */
    @Override
    public void addLog(TemplateMsgLog log) {
        logsQueue.offer(log);
    }

    /**
     * 定时将日志插入到数据库
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    synchronized void batchAddLog() {
        List<TemplateMsgLog> logs = new ArrayList<>();
        while (!logsQueue.isEmpty()) {
            logs.add(logsQueue.poll());
        }
        if (!logs.isEmpty()) {
            this.saveBatch(logs);
        }
    }
}
