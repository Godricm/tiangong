package com.kaizhuo.tiangong.boot.modules.wechat.handler;

import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

@Component
public class SubscribeHandler extends AbstractHandler {
    @Autowired
    MsgReplyService msgReplyService;
    @Autowired
    WxUserService userService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser() + "，事件：" + wxMessage.getEventKey());

        userService.refreshUserInfo(wxMessage.getFromUser());

        msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEvent());

        // 处理特殊事件，如用户扫描带参二维码关注
        if (!StringUtils.isEmpty(wxMessage.getEventKey())) {
            msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEventKey());
        }
        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
        this.logger.info("特殊请求-新关注用户 OPENID: " + wxMessage.getFromUser());
        //对关注事件和扫码事件分别处理
        msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEvent());
        if (!StringUtils.isEmpty(wxMessage.getEventKey())) {
            msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEventKey());
        }
        return null;
    }

}