package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.wechat.mapper.WxMsgMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxMsg;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxMsgService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service
public class WxMsgServiceImpl extends BaseServiceImpl<WxMsgMapper, WxMsg> implements WxMsgService {
    /**
     * 未保存的队列
     */
    private static ConcurrentLinkedQueue<WxMsg> logsQueue = new ConcurrentLinkedQueue<>();


    /**
     * 添加访问log到队列中，队列数据会定时批量插入到数据库
     * @param log
     */
    @Override
    public void addWxMsg(WxMsg log) {
        logsQueue.offer(log);
    }

    /**
     * 定时将日志插入到数据库
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    synchronized void batchAddLog(){
        List<WxMsg> logs = new ArrayList<>();
        while (!logsQueue.isEmpty()){
            logs.add(logsQueue.poll());
        }
        if(!logs.isEmpty()){
            this.saveBatch(logs);
        }
    }

}