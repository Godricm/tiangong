package com.kaizhuo.tiangong.boot.modules.wechat.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.MsgTemplate;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description: 消息模板
 * @author: miaochen
 * @create: 2020-05-25 22:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface MsgTemplateService extends BaseService<MsgTemplate> {
    /**
     * 通过模板名称查询
     *
     * @param name
     * @return
     */
    MsgTemplate selectByName(String name);

    /**
     * 同步公众号已添加的消息模板
     * @throws WxErrorException
     */
    void syncWxTemplate() throws WxErrorException;
}
