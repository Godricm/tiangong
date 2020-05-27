package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserRoleMapping;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.UserRoleMappingMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserRoleMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserRoleMappingServiceImpl extends BaseServiceImpl<UserRoleMappingMapper, UserRoleMapping> implements IUserRoleMappingService {

    @Override
    public void removeByRoleId(Long roleId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("role_id", roleId));
    }

    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> roleIds) {
        List<UserRoleMapping> userRoleMappings = new ArrayList<>();
        for(Long roleId : roleIds){
            UserRoleMapping mapping = new UserRoleMapping();
            mapping.setUserId(userId);
            mapping.setRoleId(roleId);
            userRoleMappings.add(mapping);
        }
        saveBatch(userRoleMappings);
    }
}
