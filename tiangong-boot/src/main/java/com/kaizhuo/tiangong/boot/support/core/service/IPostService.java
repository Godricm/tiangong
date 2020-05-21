package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.Post;

import java.util.List;


public interface IPostService extends BaseService<Post> {
    List<Post> getUserPosts(Long userId);

    void bindUserPost(Long userId, List<Long> postIds);
}
