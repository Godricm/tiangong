package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.entity.Post;
import com.kaizhuo.tiangong.boot.module.user.mapper.PostMapper;
import com.kaizhuo.tiangong.boot.module.user.service.PostService;
import com.kaizhuo.tiangong.boot.module.user.service.UserPostMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:25
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private UserPostMappingService userPostMappingService;

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
