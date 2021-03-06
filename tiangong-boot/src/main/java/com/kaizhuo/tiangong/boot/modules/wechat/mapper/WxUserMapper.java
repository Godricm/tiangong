package com.kaizhuo.tiangong.boot.modules.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxUser;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxUserMapper extends BaseMapper<WxUser> {

    void unsubscribe(String openid);
}
