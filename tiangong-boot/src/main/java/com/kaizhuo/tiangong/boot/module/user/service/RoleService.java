package com.kaizhuo.tiangong.boot.module.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.Role;
import com.kaizhuo.tiangong.boot.module.user.vo.request.RoleFilterVo;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
 * @description: 角色服务
 * @author: miaochen
 * @create: 2020-05-15 23:37
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface RoleService extends BaseService<Role> {
    /**
     * 获取用户的角色
     * @param userId
     * @return
     */
    List<Role> getUserRoles(Long userId);

    /**
     * 获取用的所有角色
     * @param userId
     * @return
     */
    List<Role> getUserAllRoles(Long userId);

    /**
     * 获取所有角色的id
     * @param userId
     * @return
     */
    List<Long> getUserAllRoleIds(Long userId);

    /**
     * 获取用户组下角色
     * @param groupIds
     * @return
     */
    List<Role> getGroupRoles(List<Long> groupIds);

    /**
     * 查询角色列表
     * @param filterVo
     * @return
     */
    IPage<Role> getRoles(RoleFilterVo filterVo);

    /**
     * 删除
     * @param roleId
     */
    void deleteById(Long roleId);

    /**
     * 映射
     * @param userId
     * @param roleIds
     */
    void bindUserRole(Long userId, List<Long> roleIds);
}
