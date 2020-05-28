package com.kaizhuo.tiangong.boot.modules.wechat.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Nifury
 * @date 2017-11-1
 */
@Data
@TableName("wx_msg_reply_rule")
public class MsgReplyRule extends BaseModel<MsgReplyRule> {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private int ruleId;
    @NotEmpty(message = "规则名称不得为空")
    private String ruleName;
    @NotEmpty(message = "匹配关键词不得为空")
    private String matchValue;
    private boolean exactMatch;
    private String replyType;
    @NotEmpty(message = "回复内容不得为空")
    private String replyContent;
    @TableField(value = "`status`")
    private boolean status;
    @TableField(value = "`desc`")
    private String desc;
    private LocalTime effectTimeStart;
    private LocalTime effectTimeEnd;
    private int priority;
    private Date updateTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
