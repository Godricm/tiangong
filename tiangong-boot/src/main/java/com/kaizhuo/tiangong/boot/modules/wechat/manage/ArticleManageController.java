package com.kaizhuo.tiangong.boot.modules.wechat.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wechat.entity.WxArticle;
import com.kaizhuo.tiangong.boot.modules.wechat.service.WxArticleService;
import org.springframework.web.bind.annotation.*;


/**
 * 文章
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:16
 */
@RestController
@RequestMapping("/v1/manager/article")
public class ArticleManageController  extends BaseController<WxArticleService, WxArticle> {


}
