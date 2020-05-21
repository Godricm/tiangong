package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.UserPostMapping;
import com.kaizhuo.tiangong.boot.support.core.mapper.UserPostMappingMapper;
import com.kaizhuo.tiangong.boot.support.core.service.IUserPostMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostMappingServiceImpl extends BaseServiceImpl<UserPostMappingMapper, UserPostMapping> implements IUserPostMappingService {
    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserPostMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> postIds) {
        List<UserPostMapping> userDeptMappings = new ArrayList<>();
        for(Long postId : postIds){
            UserPostMapping mapping = new UserPostMapping();
            mapping.setUserId(userId);
            mapping.setPostId(postId);
            userDeptMappings.add(mapping);
        }
        saveBatch(userDeptMappings);
    }
}
