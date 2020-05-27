package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserGroup;

import java.util.List;


public interface IUserGroupService extends BaseService<UserGroup> {
    void bindUsers(Long groupId, List<Long> userIds);

    void bindRoles(Long groupId, List<Long> roleIds);

    List<Long> getUserGroupIds(Long userId);

}
