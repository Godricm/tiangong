package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.RoleResourceMapping;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
 * @description: 角色资源映射
 * @author: miaochen
 * @create: 2020-05-15 23:36
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface RoleResourceMappingService extends BaseService<RoleResourceMapping> {
    /**
     * 移除角色
     * @param roleId
     */
    void removeByRoleId(Long roleId);

    /**
     * 移除资源
     * @param resourceId
     */
    void removeByResourceId(Long resourceId);

    /**
     * 映射
     * @param roleId
     * @param resourceIds
     */
    void bindMapping(Long roleId, List<Long> resourceIds);
}
