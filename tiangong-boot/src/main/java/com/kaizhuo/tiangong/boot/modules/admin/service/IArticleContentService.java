package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.ArticleContent;

public interface IArticleContentService extends BaseService<ArticleContent> {
    ArticleContent getByActicleId(Long acticleId);
}
