package com.kaizhuo.tiangong.boot.modules.wx.controller;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.Article;
import com.kaizhuo.tiangong.boot.modules.wx.enums.ArticleTypeEnum;
import com.kaizhuo.tiangong.boot.modules.wx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.modules.wx.controller
 * @description: 文章、公告
 * @author: miaochen
 * @create: 2020-05-26 21:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * 查看文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/detail")
    public ResponseVo<Article> getArticle(int articleId) {
        Article article = articleService.findById(articleId);
        //sysLogService.addLog(SysOperationEnum.查看文章,"articleId:"+articleId);
        return new ResponseVo<>(article);
    }

    /**
     * 查看目录
     *
     * @param category
     * @return
     */
    @GetMapping("/category")
    public ResponseVo<List<Article>> getQuestions(String type, String category) {
        ArticleTypeEnum articleType = ArticleTypeEnum.of(type);
        if (articleType == null) {
            return new ResponseVo<>(CoreErrorCode.PARAM_ERROR.getCode(),"文章类型有误");
        }
        List<Article> articles = articleService.selectCategory(articleType, category);
        return new ResponseVo<>(articles);
    }

    /**
     * 文章搜索
     *
     * @param category
     * @param keywords
     * @return
     */
    @GetMapping("/search")
    public ResponseVo<List<Article>> getQuestions(String type,
                          @RequestParam(required = false) String category,
                          @RequestParam(required = false) String keywords) {
        ArticleTypeEnum articleType = ArticleTypeEnum.of(type);
        if (articleType == null) {
            return new ResponseVo<>( CoreErrorCode.PARAM_ERROR.getCode(),"文章类型有误");
        }
        if (StringUtils.isEmpty(keywords)) {
            return new ResponseVo<>(CoreErrorCode.PARAM_ERROR.getCode(),"关键词不得为空");
        }
        List<Article> articles = articleService.search(articleType, category, keywords);
        return new ResponseVo<>(articles);
    }
}
