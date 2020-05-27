package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.entity.RoleResourceMapping;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.RoleResourceMappingMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IRoleResourceMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoleResourceMappingServiceImpl extends BaseServiceImpl<RoleResourceMappingMapper, RoleResourceMapping> implements IRoleResourceMappingService {

    @Override
    public void removeByRoleId(Long roleId) {
        remove(new QueryWrapper<RoleResourceMapping>().eq("role_id", roleId));
    }

    @Override
    public void removeByResourceId(Long resourceId) {
        remove(new QueryWrapper<RoleResourceMapping>().eq("resource_id", resourceId));
    }

    @Override
    public void bindMapping(Long roleId, List<Long> resourceIds) {
        List<RoleResourceMapping> resourceMappings = new ArrayList<>();
        for(Long resourceId : resourceIds){
            RoleResourceMapping mapping = new RoleResourceMapping();
            mapping.setRoleId(roleId);
            mapping.setResourceId(resourceId);
            resourceMappings.add(mapping);
        }
        saveBatch(resourceMappings);
    }
}
