package com.kaizhuo.tiangong.boot.modules.wechat.service;

import com.kaizhuo.tiangong.boot.modules.wechat.form.TemplateMsgBatchForm;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.scheduling.annotation.Async;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 微信模板消息处理
 * @author: miaochen
 * @create: 2020-05-25 22:50
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface TemplateMsgService {
    /**
     * 发送微信模版消息
     */
    @Async
    void sendTemplateMsg(WxMpTemplateMessage msg);

    /**
     * 批量消息发送
     * @param form
     */
    void sendMsgBatch(TemplateMsgBatchForm form);
}
