package com.kaizhuo.tiangong.boot.modules.wechat.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.wechat.mapper.MsgReplyRuleMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.MsgReplyRule;
import com.kaizhuo.tiangong.boot.modules.wechat.service.MsgReplyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-25 22:39
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class MsgReplyRuleServiceImpl extends BaseServiceImpl<MsgReplyRuleMapper, MsgReplyRule> implements MsgReplyRuleService {

    @Autowired
    MsgReplyRuleMapper msgReplyRuleMapper;

    @Override
    public List<MsgReplyRule> getRules() {
        return null;
    }

    @Override
    public List<MsgReplyRule> getValidRules() {
        return null;
    }

    @Override
    public List<MsgReplyRule> getMatchedRules(boolean exactMatch, String keywords) {
        return null;
    }

    @Override
    public boolean save(MsgReplyRule entity) {
        if (entity.getRuleId() > 0) {
            msgReplyRuleMapper.updateById(entity);
        } else {
            msgReplyRuleMapper.insert(entity);
        }
        return false;
    }
}
