package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kaizhuo.tiangong.boot.framework.config.TaskExcutor;
import com.kaizhuo.tiangong.boot.framework.validator.Assert;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxArticle;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.MsgReplyRule;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxMsg;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxArticleService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyRuleService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyService;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service.impl
 * @description: 公众号消息处理
 * @author: miaochen
 * @create: 2020-05-25 23:11
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class MsgReplyServiceImpl  implements MsgReplyService {

    @Autowired
    MsgReplyRuleService msgReplyRuleService;
    @Autowired
    WxMpService wxService;

    @Autowired
    WxArticleService wxArticleService;

    @Value("${wx.mp.autoReplyInterval:1000}")
    Long autoReplyInterval;
    @Autowired
    WxMsgService wxMsgService;

    @Override
    public boolean tryAutoReply(boolean exactMatch, String toUser, String keywords) {
        try {
            List<MsgReplyRule> rules = msgReplyRuleService.getMatchedRules(exactMatch, keywords);
            if (rules.isEmpty()) {
                return false;
            }
            long delay = 0;
            for (MsgReplyRule rule : rules) {
                TaskExcutor.schedule(() -> {
                    this.reply(toUser,rule.getReplyType(),rule.getReplyContent());
                }, delay, TimeUnit.MILLISECONDS);
                delay += autoReplyInterval;
            }
            return true;
        } catch (Exception e) {
            log.error("自动回复出错：", e);
        }
        return false;
    }

    @Override
    public void replyText(String toUser, String replyContent) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.TEXT().toUser(toUser).content(replyContent).build());

        JSONObject json = new JSONObject().fluentPut("content",replyContent);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.TEXT,toUser,json));
    }

    @Override
    public void replyImage(String toUser, String mediaId) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.IMAGE().toUser(toUser).mediaId(mediaId).build());

        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    @Override
    public void replyVoice(String toUser, String mediaId) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.VOICE().toUser(toUser).mediaId(mediaId).build());

        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.VOICE,toUser,json));
    }

    @Override
    public void replyVideo(String toUser, String mediaId) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.VIDEO().toUser(toUser).mediaId(mediaId).build());

        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.VIDEO,toUser,json));
    }

    @Override
    public void replyMusic(String toUser, String mediaId) throws WxErrorException {
        JSONObject json = JSON.parseObject(mediaId);
        wxService.getKefuService().sendKefuMessage(
                WxMpKefuMessage.MUSIC().toUser(toUser)
                        .musicUrl(json.getString("musicurl"))
                        .hqMusicUrl(json.getString("hqmusicurl"))
                        .title(json.getString("title"))
                        .description(json.getString("description"))
                        .thumbMediaId(json.getString("thumb_media_id"))
                        .build());

        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    @Override
    public void replyNews(String toUser, String newsIds) throws WxErrorException {
        Assert.isBlank(newsIds,"文章ID不得为空");
        int articleId = Integer.parseInt(newsIds);
        WxArticle a = wxArticleService.findById(articleId);
        WxMpKefuMessage.WxArticle wxArticle = new WxMpKefuMessage.WxArticle(a.getTitle(),a.getSummary(),a.getTargetLink(),a.getImage());
        List<WxMpKefuMessage.WxArticle> newsList = new ArrayList<WxMpKefuMessage.WxArticle>(){{add(wxArticle);}};
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.NEWS().toUser(toUser).articles(newsList).build());

        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.NEWS,toUser,(JSONObject)JSONObject.toJSON(wxArticle)));
    }

    @Override
    public void replyMpNews(String toUser, String mediaId) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.MPNEWS().toUser(toUser).mediaId(mediaId).build());

        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.MPNEWS,toUser,json));
    }

    @Override
    public void replyWxCard(String toUser, String cardId) throws WxErrorException {
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.WXCARD().toUser(toUser).cardId(cardId).build());

        JSONObject json = new JSONObject().fluentPut("cardId",cardId);
        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.WXCARD,toUser,json));
    }

    @Override
    public void replyMiniProgram(String toUser, String miniProgramInfoJson) throws WxErrorException {
        JSONObject json = JSON.parseObject(miniProgramInfoJson);
        wxService.getKefuService().sendKefuMessage(
                WxMpKefuMessage.MINIPROGRAMPAGE()
                        .toUser(toUser)
                        .title(json.getString("title"))
                        .appId(json.getString("appid"))
                        .pagePath(json.getString("pagepath"))
                        .thumbMediaId(json.getString("thumb_media_id"))
                        .build());

        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    @Override
    public void replyMsgMenu(String toUser, String msgMenusJson) throws WxErrorException {
        JSONObject json = JSON.parseObject(msgMenusJson);
        List<WxMpKefuMessage.MsgMenu> msgMenus = json.getJSONArray("list").toJavaList(WxMpKefuMessage.MsgMenu.class);
        wxService.getKefuService().sendKefuMessage(
                WxMpKefuMessage.MSGMENU()
                        .toUser(toUser)
                        .headContent(json.getString("head_content"))
                        .tailContent(json.getString("tail_content"))
                        .msgMenus(msgMenus).build());

        wxMsgService.addWxMsg(WxMsg.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }
}
