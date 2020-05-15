package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.UserGroup;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description:
 * @author: miaochen
 * @create: 2020-05-15 23:42
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserGroupService extends BaseService<UserGroup> {
    void bindUsers(Long groupId, List<Long> userIds);

    void bindRoles(Long groupId, List<Long> roleIds);

    List<Long> getUserGroupIds(Long userId);
}
