package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.RoleResourceMapping;

import java.util.List;


public interface IRoleResourceMappingService extends BaseService<RoleResourceMapping> {
    void removeByRoleId(Long roleId);

    void removeByResourceId(Long resourceId);

    void bindMapping(Long roleId, List<Long> resourceIds);
}
