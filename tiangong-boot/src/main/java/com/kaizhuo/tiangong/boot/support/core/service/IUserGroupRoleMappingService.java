package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.UserGroupRoleMapping;

import java.io.Serializable;
import java.util.List;

public interface IUserGroupRoleMappingService extends BaseService<UserGroupRoleMapping> {
    void bindMapping(Long groupId, List<Long> roleIds);

    void removeByGroupId(Serializable groupId);
}
