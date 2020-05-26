package com.kaizhuo.tiangong.boot.modules.wx.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description: 消息回复
 * @author: miaochen
 * @create: 2020-05-24 23:11
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class WxMsgReplyForm {
    @NotEmpty(message = "用户信息不得为空")
    private String openid;
    @NotEmpty(message = "回复类型不得为空")
    private String replyType;
    @NotEmpty(message = "回复内容不得为空")
    private String replyContent;
}
