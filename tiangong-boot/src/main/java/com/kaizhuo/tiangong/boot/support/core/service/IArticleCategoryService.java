package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.ArticleCategory;
import com.kaizhuo.tiangong.boot.support.core.vo.response.ArticleCateVo;

import java.util.List;

public interface IArticleCategoryService extends BaseService<ArticleCategory> {
    boolean save(ArticleCategory articleCategory);

    boolean removeById(Long categoryId);

    boolean updateById(ArticleCategory articleCategory);

    List<ArticleCateVo> getTreeCates();

    List<Long> getCateIdsByParentId(Long cateId);
}
