package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserRoleMapping;

import java.util.List;


public interface IUserRoleMappingService extends BaseService<UserRoleMapping> {
    void removeByRoleId(Long roleId);

    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> roleIds);
}
