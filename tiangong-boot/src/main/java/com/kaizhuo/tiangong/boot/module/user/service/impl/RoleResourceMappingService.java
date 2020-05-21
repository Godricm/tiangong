package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.entity.RoleResourceMapping;
import com.kaizhuo.tiangong.boot.module.user.mapper.RoleResourceMappingMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:49
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class RoleResourceMappingService extends BaseServiceImpl<RoleResourceMappingMapper, RoleResourceMapping> implements com.kaizhuo.tiangong.boot.module.user.service.RoleResourceMappingService {
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
        for (Long resourceId : resourceIds) {
            RoleResourceMapping mapping=new RoleResourceMapping();
            mapping.setRoleId(roleId);
            mapping.setResourceId(resourceId);
            resourceMappings.add(mapping);
        }
        saveBatch(resourceMappings);
    }
}
