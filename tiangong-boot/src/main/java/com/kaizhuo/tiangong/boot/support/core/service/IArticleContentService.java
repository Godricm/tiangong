package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.ArticleContent;

public interface IArticleContentService extends BaseService<ArticleContent> {
    ArticleContent getByActicleId(Long acticleId);
}
