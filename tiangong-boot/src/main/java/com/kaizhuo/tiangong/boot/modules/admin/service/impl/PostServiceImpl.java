package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Post;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.PostMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IPostService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserPostMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl extends BaseServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    private IUserPostMappingService userPostMappingService;

    @Override
    public List<Post> getUserPosts(Long userId) {
        List<Post> userDepts = baseMapper.getUserPosts(userId);
        return userDepts;
    }

    @Override
    public void bindUserPost(Long userId, List<Long> postIds) {
        // 删除用户部门映射表中该用户的所有关系
        userPostMappingService.removeByUserId(userId);

        // 重新构建新的绑定关系
        userPostMappingService.bindMapping(userId, postIds);
    }
}
