package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.ArticleContent;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.ArticleContentMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleContentService;
import org.springframework.stereotype.Service;


@Service
public class ArticleContentServiceImpl extends BaseServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService {

    @Override
    public ArticleContent getByActicleId(Long acticleId) {
        ArticleContent articleContent = getOne(new QueryWrapper<ArticleContent>().eq("article_id", acticleId));
        return articleContent;
    }
}
