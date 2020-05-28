package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.kaizhuo.tiangong.boot.modules.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.admin.entity.ArticleCategory;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleCategoryService;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ArticleCateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(Urls.ROOT+"/articleCategory")
@Api(value = "文章分类相关", tags = "文章分类相关")
public class ArticleCategoryController extends BaseController<IArticleCategoryService, ArticleCategory> {

    @RequestMapping(value = Urls.CATE_TREE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "获取树状结构文章分类列表", notes = "获取树状结构文章分类列表")
    public ResponseVo<List<ArticleCateVo>> getTreeCates(){
        List<ArticleCateVo> treeCates = bizService.getTreeCates();
        return new ResponseVo<>(treeCates);
    }
}

