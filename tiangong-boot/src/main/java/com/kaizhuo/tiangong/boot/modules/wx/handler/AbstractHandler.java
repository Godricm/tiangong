package com.kaizhuo.tiangong.boot.modules.wx.handler;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.handler
 * @description: 抽象微信处理
 * @author: miaochen
 * @create: 2020-05-24 23:36
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public abstract class AbstractHandler implements WxMpMessageHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
