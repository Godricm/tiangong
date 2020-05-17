package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.UserGroupMapping;
import com.kaizhuo.tiangonguser.mapper.UserGroupMappingMapper;
import com.kaizhuo.tiangonguser.service.UserGroupMappingService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:45
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserGroupMappingServiceImpl extends BaseServiceImpl<UserGroupMappingMapper, UserGroupMapping> implements UserGroupMappingService {
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
