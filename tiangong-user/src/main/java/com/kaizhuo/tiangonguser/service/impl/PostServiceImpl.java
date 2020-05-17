package com.kaizhuo.tiangonguser.service.impl;

import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.Post;
import com.kaizhuo.tiangonguser.mapper.PostMapper;
import com.kaizhuo.tiangonguser.service.PostService;
import com.kaizhuo.tiangonguser.service.UserPostMappingService;
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
