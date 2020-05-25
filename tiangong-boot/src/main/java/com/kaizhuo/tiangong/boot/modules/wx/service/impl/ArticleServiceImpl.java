package com.kaizhuo.tiangong.boot.modules.wx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.modules.wx.dao.ArticleMapper;
import com.kaizhuo.tiangong.boot.modules.wx.dto.PageSizeConstant;
import com.kaizhuo.tiangong.boot.modules.wx.entity.Article;
import com.kaizhuo.tiangong.boot.modules.wx.enums.ArticleTypeEnum;
import com.kaizhuo.tiangong.boot.modules.wx.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-25 22:19
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, Article> implements ArticleService {
    private static final String ID_PLACEHOLDER = "${articleId}";

    /**
     * 查询文章列表时返回的字段（过滤掉详情字段以加快速度）
     */
    private static final String LIST_FILEDS = "id,summary,image,sub_category,update_time,title,type,tags,create_time,target_link,open_count,category";


    /**
     * 查询文章详情，每次查询后增加点击次数
     *
     * @param id
     * @return
     */
    @Override
    public Article findById(int id) {
        if (id <= 0) {
            return null;
        }
        Article article = baseMapper.selectById(id);
        if (article != null) {
            baseMapper.addOpenCount(id);
        }
        return article;
    }

    /**
     * 添加或编辑文章,同名文章不可重复添加
     *
     * @param title
     * @param page
     * @return
     */
    @Override
    public IPage<Article> getArticles(String title, int page) {
        return this.page(new Page<Article>(page, PageSizeConstant.PAGE_SIZE_SMALL),
                new QueryWrapper<Article>().like(!StringUtils.isEmpty("title"), "title", title)
                        .select(LIST_FILEDS)
                        .orderBy(true, false, "update_time"));
    }

    @Override
    public List<Article> selectCategory(ArticleTypeEnum articleType, String category) {
        return this.list(new QueryWrapper<Article>()
                .select(LIST_FILEDS)
                .eq("type", articleType.getValue())
                .eq("category", category));
    }

    @Override
    public List<Article> search(ArticleTypeEnum articleType, String category, String keywords) {
        return this.list(new QueryWrapper<Article>()
                .select(LIST_FILEDS)
                .eq("type", articleType.getValue())
                .eq(!StringUtils.isEmpty(category), "category", category)
                .and(i -> i.like("summary", keywords).or().like("title", keywords)));
    }

    @Override
    public boolean save(Article entity) {
        entity.setUpdateTime(new Date());
        if (entity.getId() > 0) {
            baseMapper.updateById(entity);
        } else {
            String title = entity.getTitle();
            int count = baseMapper.selectCount(
                    new QueryWrapper<Article>().eq("title", title)
                            .eq("category", entity.getCategory())
                            .eq("sub_category", entity.getSubCategory())
            );
            if (count > 0)
                throw new BaseException("同目录下文章[" + title + "]已存在，不可重复添加", CoreErrorCode.WX_EXISTS_ERROR.getCode());
            entity.setCreateTime(new Date());
            baseMapper.insert(entity);
        }
        String targetLink = entity.getTargetLink();
        if (targetLink.indexOf(ID_PLACEHOLDER) > -1) {
            entity.setTargetLink(targetLink.replace(ID_PLACEHOLDER, entity.getId() + ""));
            baseMapper.updateById(entity);
        }
        return true;
    }
}
