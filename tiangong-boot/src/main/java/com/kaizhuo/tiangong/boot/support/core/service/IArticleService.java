package com.kaizhuo.tiangong.boot.support.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.Article;
import com.kaizhuo.tiangong.boot.support.core.vo.request.ArticleFilterVo;
import com.kaizhuo.tiangong.boot.support.core.vo.request.UpdateArticleVo;
import com.kaizhuo.tiangong.boot.support.core.vo.response.ArticleVo;

public interface IArticleService extends BaseService<Article> {
    void addInfo(UpdateArticleVo articleVo);

    void updateInfo(Long articleId, UpdateArticleVo articleVo);

    ArticleVo getInfo(Long articleId);

    IPage<Article> getArticleList(ArticleFilterVo filterVo);
}
