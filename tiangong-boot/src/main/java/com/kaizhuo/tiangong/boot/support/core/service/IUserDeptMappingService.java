package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.UserDeptMapping;

import java.util.List;


public interface IUserDeptMappingService extends BaseService<UserDeptMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> deptIds);
}
