package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.UserRoleMapping;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
 * @description: 用户角色映射
 * @author: miaochen
 * @create: 2020-05-15 23:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserRoleMappingService  extends BaseService<UserRoleMapping> {
    void removeByRoleId(Long roleId);

    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> roleIds);
}
