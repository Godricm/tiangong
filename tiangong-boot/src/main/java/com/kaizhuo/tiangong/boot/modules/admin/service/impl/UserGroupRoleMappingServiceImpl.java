package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserGroupRoleMapping;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.UserGroupRoleMappingMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserGroupRoleMappingService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupRoleMappingServiceImpl extends BaseServiceImpl<UserGroupRoleMappingMapper, UserGroupRoleMapping> implements IUserGroupRoleMappingService {

    @Override
    public void bindMapping(Long groupId, List<Long> roleIds) {
        List<UserGroupRoleMapping> userGroupRoleMappings = new ArrayList<>();
        for(Long roleId : roleIds){
            UserGroupRoleMapping mapping = new UserGroupRoleMapping();
            mapping.setGroupId(groupId);
            mapping.setRoleId(roleId);
            userGroupRoleMappings.add(mapping);
        }
        saveBatch(userGroupRoleMappings);
    }

    @Override
    public void removeByGroupId(Serializable groupId) {
        remove(new QueryWrapper<UserGroupRoleMapping>().eq("group_id", groupId));
    }
}
