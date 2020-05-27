package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.modules.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.framework.constants.Constants;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Article;
import com.kaizhuo.tiangong.boot.modules.admin.entity.User;
import com.kaizhuo.tiangong.boot.modules.admin.service.IArticleService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserService;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.ArticleFilterVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.UpdateArticleVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Urls.ARTICLE_MODULE)
@Api(value = "文章信息相关", tags = "文章信息相关")
public class ArticleController {

    @Autowired
    private IArticleService bizService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = Urls.ARTICLE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "添加文章", notes = "添加文章")
    @ResponseBody
    public ResponseVo add(@RequestHeader(Constants.HEADER_USER_ID) Long userId, UpdateArticleVo articleVo) {
        if(userId != null){
            User userInfo = userService.getById(userId);
            articleVo.setAuthorId(userId);
            articleVo.setAuthorName(userInfo.getUserName());
        }
        bizService.addInfo(articleVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.ARTICLE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "更新指定ID的文章信息", notes = "更新指定ID的文章信息")
    @ResponseBody
    public ResponseVo update(@PathVariable Long articleId, UpdateArticleVo articleVo) {
        bizService.updateInfo(articleId, articleVo);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ARTICLE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的文章", notes = "删除指定ID的文章")
    @ResponseBody
    public ResponseVo remove(@PathVariable Long articleId) {
        bizService.removeById(articleId);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ARTICLE_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取文章详情", notes = "根据id获取文章详情")
    @ResponseBody
    public ResponseVo<ArticleVo> getInfo(@PathVariable("articleId") Long articleId) {
        ArticleVo articleVo = bizService.getInfo(articleId);
        return new ResponseVo<>(articleVo);
    }

    @RequestMapping(value = Urls.ARTICLE_PAGE, method = RequestMethod.GET)
    @ApiOperation(value = "根据筛选条件分页获取文章列表", notes = "根据筛选条件分页获取文章列表")
    public ResponseVo<IPage<Article>> getArticleList(ArticleFilterVo filterVo) {
        return new ResponseVo<>(bizService.getArticleList(filterVo));
    }
}

