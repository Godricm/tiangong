package com.kaizhuo.tiangong.boot.modules.wechat.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxMsg;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 微信消息
 * @author: miaochen
 * @create: 2020-05-25 22:52
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface WxMsgService extends BaseService<WxMsg> {
    /**
     * 保存消息到数据库（会先添加到队列，再使用定时任务写入）
     * @param log
     */
    void addWxMsg(WxMsg log);
}
