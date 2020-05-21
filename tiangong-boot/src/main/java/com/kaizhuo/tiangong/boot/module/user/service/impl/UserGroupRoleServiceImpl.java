package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.entity.UserGroupRoleMapping;
import com.kaizhuo.tiangong.boot.module.user.mapper.UserGroupRoleMappingMapper;
import com.kaizhuo.tiangong.boot.module.user.service.UserGroupRoleMappingService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:46
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserGroupRoleServiceImpl extends BaseServiceImpl<UserGroupRoleMappingMapper,UserGroupRoleMapping> implements UserGroupRoleMappingService {
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
