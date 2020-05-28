package com.kaizhuo.tiangong.boot.modules.wx.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Nifury
 * @date 2017-9-27
 */
@Data
@TableName("wx_msg_template")
@EqualsAndHashCode(callSuper = false)
public class MsgTemplate extends BaseModel<MsgTemplate> {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private long id;
    private String templateId;
    @TableField(value = "`name`")
    private String name;
    private String title;
    private String content;
    private JSONArray data;
    private String url;
    private JSONObject miniprogram;
    @TableField(value = "`status`")
    private boolean status;
    private Date updateTime;
    public MsgTemplate() {

    }
    public MsgTemplate(WxMpTemplate mpTemplate) {
        this.templateId=mpTemplate.getTemplateId();
        this.title=mpTemplate.getTitle();
        this.name=mpTemplate.getTemplateId();
        this.content = mpTemplate.getContent();
        this.status=true;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
