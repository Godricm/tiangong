package com.kaizhuo.tiangong.boot.modules.wx.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.wx.entity.MsgReplyRule;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service
 * @description:
 * @author: miaochen
 * @create: 2020-05-25 22:19
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface MsgReplyRuleService extends BaseService<MsgReplyRule> {
    /**
     * 保存自动回复规则
     *
     * @param msgReplyRule
     */

    boolean save(MsgReplyRule msgReplyRule);

    /**
     * 获取所有的回复规则
     *
     * @return
     */
    List<MsgReplyRule> getRules();

    /**
     * 获取当前时段内所有有效的回复规则
     *
     * @return 有效的规则列表
     */
    List<MsgReplyRule> getValidRules();

    /**
     * 筛选符合条件的回复规则
     *
     * @param exactMatch 是否精确匹配
     * @param keywords   关键词
     * @return 规则列表
     */
    List<MsgReplyRule> getMatchedRules(boolean exactMatch, String keywords);
}
