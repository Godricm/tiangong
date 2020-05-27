package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserGroupMapping;

import java.io.Serializable;
import java.util.List;


public interface IUserGroupMappingService extends BaseService<UserGroupMapping> {
    void bindMapping(Long groupId, List<Long> userIds);

    void removeByGroupId(Serializable groupId);
}
