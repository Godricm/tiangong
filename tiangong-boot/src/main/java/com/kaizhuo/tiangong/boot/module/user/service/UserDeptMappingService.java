package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.UserDeptMapping;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
 * @description:
 * @author: miaochen
 * @create: 2020-05-15 23:40
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserDeptMappingService extends BaseService<UserDeptMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> deptIds);
}
