package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.UserGroupRoleMapping;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 用户组角色映射
 * @author: miaochen
 * @create: 2020-05-15 23:41
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserGroupRoleMappingService extends BaseService<UserGroupRoleMapping> {
    void bindMapping(Long groupId, List<Long> roleIds);

    void removeByGroupId(Serializable groupId);
}
