package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Role;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.RoleFilterVo;

import java.util.List;


public interface IRoleService extends BaseService<Role> {
    List<Role> getUserRoles(Long userId);

    List<Role> getUserAllRoles(Long userId);

    List<Long> getUserAllRoleIds(Long userId);

    List<Role> getGroupRoles(List<Long> groupIds);

    IPage<Role> getRoles(RoleFilterVo filterVo);

    void deleteById(Long roleId);

    void bindUserRole(Long userId, List<Long> roleIds);
}
