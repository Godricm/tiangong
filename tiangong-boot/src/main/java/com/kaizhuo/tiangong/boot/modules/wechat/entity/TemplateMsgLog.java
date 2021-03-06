package com.kaizhuo.tiangong.boot.modules.wechat.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.Date;

/**
 * @author Nifury
 * @date 2017-9-27
 */
@Data
@TableName("wx_template_msg_log")
public class TemplateMsgLog extends BaseModel<TemplateMsgLog> {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private int logId;
    private String touser;
    private String templateId;
    private JSONArray data;
    private String url;
    private JSONObject miniprogram;
    private Date sendTime;
    private String sendResult;

    public TemplateMsgLog() {
    }

    public TemplateMsgLog(WxMpTemplateMessage msg, String sendResult) {
        this.touser = msg.getToUser();
        this.templateId = msg.getTemplateId();
        this.url = msg.getUrl();
        this.miniprogram = JSONObject.parseObject(JSON.toJSONString(msg.getMiniProgram()));
        this.data = JSONArray.parseArray(JSON.toJSONString(msg.getData()));
        this.sendTime = new Date();
        this.sendResult = sendResult;
    }
}
