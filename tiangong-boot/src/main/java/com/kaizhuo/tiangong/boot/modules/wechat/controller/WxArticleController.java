package com.kaizhuo.tiangong.boot.modules.wechat.controller;

import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxArticle;
import com.kaizhuo.tiangong.boot.modules.wechat.enums.ArticleTypeEnum;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxArticleService;
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
@RequestMapping("/v1/wx/Article")
public class WxArticleController {
    @Autowired
    WxArticleService wxArticleService;

    /**
     * 查看文章详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/detail")
    public ResponseVo<WxArticle> getArticle(int articleId) {
        WxArticle wxArticle = wxArticleService.findById(articleId);
        //sysLogService.addLog(SysOperationEnum.查看文章,"articleId:"+articleId);
        return new ResponseVo<>(wxArticle);
    }

    /**
     * 查看目录
     *
     * @param category
     * @return
     */
    @GetMapping("/category")
    public ResponseVo<List<WxArticle>> getQuestions(String type, String category) {
        ArticleTypeEnum articleType = ArticleTypeEnum.of(type);
        if (articleType == null) {
            return new ResponseVo<>(CoreErrorCode.PARAM_ERROR.getCode(),"文章类型有误");
        }
        List<WxArticle> wxArticles = wxArticleService.selectCategory(articleType, category);
        return new ResponseVo<>(wxArticles);
    }

    /**
     * 文章搜索
     *
     * @param category
     * @param keywords
     * @return
     */
    @GetMapping("/search")
    public ResponseVo<List<WxArticle>> getQuestions(String type,
                                                    @RequestParam(required = false) String category,
                                                    @RequestParam(required = false) String keywords) {
        ArticleTypeEnum articleType = ArticleTypeEnum.of(type);
        if (articleType == null) {
            return new ResponseVo<>( CoreErrorCode.PARAM_ERROR.getCode(),"文章类型有误");
        }
        if (StringUtils.isEmpty(keywords)) {
            return new ResponseVo<>(CoreErrorCode.PARAM_ERROR.getCode(),"关键词不得为空");
        }
        List<WxArticle> wxArticles = wxArticleService.search(articleType, category, keywords);
        return new ResponseVo<>(wxArticles);
    }
}
