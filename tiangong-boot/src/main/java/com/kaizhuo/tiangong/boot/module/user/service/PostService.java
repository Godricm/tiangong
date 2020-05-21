package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.Post;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
 * @description: 岗位服务
 * @author: miaochen
 * @create: 2020-05-15 23:31
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface PostService extends BaseService<Post> {
    List<Post> getUserPosts(Long userId);

    void bindUserPost(Long userId, List<Long> postIds);
}
