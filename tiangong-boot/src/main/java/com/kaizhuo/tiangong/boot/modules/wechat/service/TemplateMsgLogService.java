package com.kaizhuo.tiangong.boot.modules.wechat.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.TemplateMsgLog;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 模板消息日志
 * @author: miaochen
 * @create: 2020-05-25 22:49
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface TemplateMsgLogService extends BaseService<TemplateMsgLog> {

    /**
     * 添加访问log到队列中，队列数据会定时批量插入到数据库
     *
     * @param log
     */
    void addLog(TemplateMsgLog log);
}
