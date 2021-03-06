package com.kaizhuo.tiangong.boot.modules.wechat.handler;

import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ScanHandler extends AbstractHandler {
    @Autowired
    MsgReplyService msgReplyService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                    WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        //扫码事件处理
        this.logger.info("用户扫描带参二维码 OPENID: " + wxMpXmlMessage.getFromUser());
        msgReplyService.tryAutoReply(true, wxMpXmlMessage.getFromUser(), wxMpXmlMessage.getEventKey());

        return null;
    }
}
