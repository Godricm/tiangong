package com.kaizhuo.tiangong.boot.modules.wx.manage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.wx.entity.Article;
import com.kaizhuo.tiangong.boot.modules.wx.service.ArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 文章
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2019-11-12 18:30:16
 */
@RestController
@RequestMapping("/wx/article")
public class ArticleManageController {
    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
//    @GetMapping("/list")
//    @RequiresPermissions("wx:article:list")
//    public ResponseVo<IPage> list(@RequestParam Map<String, Object> params) {
//        IPage<>
//
//        return new ResponseVo();
//    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("wx:article:info")
    public ResponseVo<Article> info(@PathVariable("id") Integer id) {
        Article article = articleService.getById(id);

        return new ResponseVo<>(article);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("wx:article:save")
    public ResponseVo save(@RequestBody Article article) {
        articleService.save(article);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @RequiresPermissions("wx:article:delete")
    public ResponseVo delete(@RequestBody Integer[] ids) {
        articleService.removeByIds(Arrays.asList(ids));

        return ResponseVo.ok();
    }

}
