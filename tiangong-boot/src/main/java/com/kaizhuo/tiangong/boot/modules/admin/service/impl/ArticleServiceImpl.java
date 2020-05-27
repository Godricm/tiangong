package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.constants.ArticleErrorCode;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Article;
import com.kaizhuo.tiangong.boot.modules.admin.entity.ArticleContent;
import com.kaizhuo.tiangong.boot.modules.admin.exception.ArticleException;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.ArticleMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleCategoryService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleContentService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleService;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.ArticleFilterVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.UpdateArticleVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private IArticleContentService articleContentService;
    @Autowired
    private IArticleCategoryService articleCategoryService;

    @Override
    @Transactional
    public void addInfo(UpdateArticleVo articleVo) {
        // 先将文章基本信息插入
        Article article = new Article();
        BeanUtils.copyProperties(articleVo, article);
        article.setPublishTime(new Date());

        save(article);

        // 再插入文章扩展内容
        String articleContent = articleVo.getArticleContent();
        Long articleId = article.getArticleId();
        ArticleContent content = new ArticleContent();
        content.setArticleId(articleId);
        content.setArticleContent(articleContent);
        articleContentService.save(content);
    }

    @Override
    @Transactional
    public void updateInfo(Long articleId, UpdateArticleVo articleVo) {
        // 先更新文章基本信息
        Article article = getById(articleId);
        if(article == null){
            throw new ArticleException(ArticleErrorCode.ARTICLE_NOT_EXIST_ERROR.getCode());
        }

        BeanUtils.copyProperties(articleVo, article);

        updateById(article);

        // 再更新文章扩展内容
        ArticleContent articleContent = articleContentService.getByActicleId(articleId);
        if(articleContent != null){
            ArticleContent content = new ArticleContent();
            content.setContentId(articleContent.getContentId());
            content.setArticleContent(articleVo.getArticleContent());
            articleContentService.updateById(content);
        }
    }

    @Override
    public ArticleVo getInfo(Long articleId) {
        // 获取文章基本信息
        ArticleVo articleVo = new ArticleVo();

        Article article = getById(articleId);
        if(article == null){
            throw new ArticleException(ArticleErrorCode.ARTICLE_NOT_EXIST_ERROR.getCode());
        }

        BeanUtils.copyProperties(article, articleVo);

        // 获取文章扩展信息
        ArticleContent articleContent = articleContentService.getByActicleId(articleId);
        if(articleContent != null){
            articleVo.setArticleContent(articleContent.getArticleContent());
        }

        return articleVo;
    }

    @Override
    public IPage<Article> getArticleList(ArticleFilterVo filterVo) {
        // 分类ID不为空,则获取该分类ID及所有子分类ID
        Long cateId = filterVo.getCateId();
        if(cateId != null && cateId != 0){
            List<Long> cateIds = articleCategoryService.getCateIdsByParentId(cateId);
            cateIds.add(cateId);

            filterVo.setAllCateIds(cateIds);
        }

        return baseMapper.getArticleList(convertPageParam(filterVo), filterVo);
    }
}
