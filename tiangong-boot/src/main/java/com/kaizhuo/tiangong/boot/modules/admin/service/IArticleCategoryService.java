package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.ArticleCategory;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ArticleCateVo;

import java.util.List;

public interface IArticleCategoryService extends BaseService<ArticleCategory> {
    boolean save(ArticleCategory articleCategory);

    boolean removeById(Long categoryId);

    boolean updateById(ArticleCategory articleCategory);

    List<ArticleCateVo> getTreeCates();

    List<Long> getCateIdsByParentId(Long cateId);
}
