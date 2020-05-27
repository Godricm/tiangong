package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.modules.wx.entity.WxArticle;
import com.kaizhuo.tiangong.boot.modules.wx.service.WxArticleService;
import org.springframework.web.bind.annotation.*;


/**
 * 文章
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:16
 */
@RestController
@RequestMapping("/wx/article")
public class ArticleManageController  extends BaseController<WxArticleService, WxArticle> {


}
