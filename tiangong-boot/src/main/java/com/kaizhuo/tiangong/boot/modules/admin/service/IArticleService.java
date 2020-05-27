package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Article;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.ArticleFilterVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.UpdateArticleVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ArticleVo;

public interface IArticleService extends BaseService<Article> {
    void addInfo(UpdateArticleVo articleVo);

    void updateInfo(Long articleId, UpdateArticleVo articleVo);

    ArticleVo getInfo(Long articleId);

    IPage<Article> getArticleList(ArticleFilterVo filterVo);
}
