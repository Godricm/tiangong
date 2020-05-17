package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.RoleResourceMapping;
import com.kaizhuo.tiangonguser.mapper.RoleResourceMappingMapper;
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
public class RoleResourceMappingService extends BaseServiceImpl<RoleResourceMappingMapper, RoleResourceMapping> implements com.kaizhuo.tiangonguser.service.RoleResourceMappingService {
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
