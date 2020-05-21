package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.entity.UserPostMapping;
import com.kaizhuo.tiangong.boot.module.user.mapper.UserPostMappingMapper;
import com.kaizhuo.tiangong.boot.module.user.service.UserPostMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:48
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserPostMappingServiceImpl extends BaseServiceImpl<UserPostMappingMapper, UserPostMapping> implements UserPostMappingService {
    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserPostMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> postIds) {
        List<UserPostMapping> userDeptMappings = new ArrayList<>();
        for (Long postId : postIds) {
            UserPostMapping mapping = new UserPostMapping();
            mapping.setUserId(userId);
            mapping.setPostId(postId);
            userDeptMappings.add(mapping);
        }
        saveBatch(userDeptMappings);
    }
}
