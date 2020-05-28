package com.kaizhuo.tiangong.boot.modules.wechat.form;

import lombok.Data;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.form
 * @description: 模板消息多条
 * @author: miaochen
 * @create: 2020-05-24 22:51
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
public class TemplateMsgBatchForm {
    @NotNull(message = "需用户筛选条件参数")
    Map<String, Object> wxUserFilterParams;
    @NotEmpty(message = "模板ID不得为空")
    private String templateId;
    private String url;
    private WxMpTemplateMessage.MiniProgram miniprogram;
    @NotEmpty(message = "消息模板数据不得为空")
    private List<WxMpTemplateData> data;
}
