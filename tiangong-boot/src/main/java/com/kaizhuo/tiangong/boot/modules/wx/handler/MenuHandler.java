package com.kaizhuo.tiangong.boot.modules.wx.handler;

import com.kaizhuo.tiangong.boot.modules.wx.service.MsgReplyService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.handler
 * @description: 菜单
 * @author: miaochen
 * @create: 2020-05-24 23:40
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Component
public class MenuHandler extends AbstractHandler {

    @Autowired
    MsgReplyService msgReplyService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        if (WxConsts.EventType.VIEW.equals(wxMessage.getEvent())) {
            return null;
        }
        logger.info("菜单事件：" + wxMessage.getEventKey());
        msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEventKey());
        return null;
    }
}
