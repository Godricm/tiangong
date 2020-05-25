package com.kaizhuo.tiangong.boot.modules.wx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.framework.validator.Assert;
import com.kaizhuo.tiangong.boot.modules.wx.dao.MsgTemplateMapper;
import com.kaizhuo.tiangong.boot.modules.wx.entity.MsgTemplate;
import com.kaizhuo.tiangong.boot.modules.wx.service.MsgTemplateService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service.impl
 * @description: 模板消息
 * @author: miaochen
 * @create: 2020-05-25 23:26
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class MsgTemplateServiceImpl extends BaseServiceImpl<MsgTemplateMapper, MsgTemplate> implements MsgTemplateService {
    @Autowired
    private WxMpService wxService;

    @Override
    public MsgTemplate selectByName(String name) {
        Assert.isBlank(name, "模板名称不得为空");
        return this.getOne(new QueryWrapper<MsgTemplate>()
                .eq("name", name)
                .eq("status", 1)
                .last("LIMIT 1"));
    }

    @Override
    public void syncWxTemplate() throws WxErrorException {
        List<WxMpTemplate> wxMpTemplateList= wxService.getTemplateMsgService().getAllPrivateTemplate();
        List<MsgTemplate> templates = wxMpTemplateList.stream().map(MsgTemplate::new).collect(Collectors.toList());
        this.saveBatch(templates);
    }
}
