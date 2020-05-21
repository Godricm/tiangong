package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.UserPostMapping;

import java.util.List;


public interface IUserPostMappingService extends BaseService<UserPostMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> postIds);
}
