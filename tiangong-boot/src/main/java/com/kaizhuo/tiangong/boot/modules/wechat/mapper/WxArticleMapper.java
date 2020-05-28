package com.kaizhuo.tiangong.boot.modules.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxArticle;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.scheduling.annotation.Async;

@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxArticleMapper extends BaseMapper<WxArticle> {
    @Async
    void addOpenCount(int id);
}
