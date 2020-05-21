package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.UserGroupMapping;
import com.kaizhuo.tiangong.boot.support.core.mapper.UserGroupMappingMapper;
import com.kaizhuo.tiangong.boot.support.core.service.IUserGroupMappingService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserGroupMappingServiceImpl extends BaseServiceImpl<UserGroupMappingMapper, UserGroupMapping> implements IUserGroupMappingService {

    @Override
    public void bindMapping(Long groupId, List<Long> userIds) {
        List<UserGroupMapping> userGroupMappings = new ArrayList<>();
        for(Long userId : userIds){
            UserGroupMapping mapping = new UserGroupMapping();
            mapping.setGroupId(groupId);
            mapping.setUserId(userId);
            userGroupMappings.add(mapping);
        }
        saveBatch(userGroupMappings);
    }

    @Override
    public void removeByGroupId(Serializable groupId) {
        remove(new QueryWrapper<UserGroupMapping>().eq("group_id", groupId));
    }
}
