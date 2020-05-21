package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.core.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.core.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.Post;
import com.kaizhuo.tiangong.boot.module.user.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
 * @description: 岗位信息相关
 * @author: miaochen
 * @create: 2020-05-18 21:19
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"post")
@Api(value = "岗位信息相关",tags = "岗位信息相关")
public class PostController extends BaseController<PostService, Post> {

    @GetMapping("/{userId}/list")
    @ApiOperation(value = "获取指定用户的岗位列表",notes = "获取指定用户的岗位列表")
    public ResponseVo<List<Post>> getUserPosts(@PathVariable("userId") Long userId){
        List<Post> userPosts=bizService.getUserPosts(userId);
        return new ResponseVo<>(userPosts);
    }

    @PutMapping("/bind/{userId}")
    @ApiOperation(value = "设置用户的岗位", notes = "设置用户的岗位")
    public ResponseVo userPostBind(@PathVariable("userId") Long userId, @ApiParam(value = "所属的岗位ID,多个以英文逗号分隔", required = true) @RequestParam(value = "postIds") String postIds){
        List<Long> postIdList= ConvertUtil.splitStr2LongList(postIds,",");
        bizService.bindUserPost(userId,postIdList);
        return new ResponseVo();
    }
}
