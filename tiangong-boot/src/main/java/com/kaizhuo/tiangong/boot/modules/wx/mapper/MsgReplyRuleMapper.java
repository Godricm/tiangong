package com.kaizhuo.tiangong.boot.modules.wx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.modules.wx.entity.MsgReplyRule;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * @author miaochen
 */
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface MsgReplyRuleMapper extends BaseMapper<MsgReplyRule> {
}
