package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserGroupRoleMapping;

import java.io.Serializable;
import java.util.List;

public interface IUserGroupRoleMappingService extends BaseService<UserGroupRoleMapping> {
    void bindMapping(Long groupId, List<Long> roleIds);

    void removeByGroupId(Serializable groupId);
}
