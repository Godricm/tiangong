package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.common.constants.Constants;
import com.kaizhuo.tiangong.boot.common.util.CollectionUtil;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.constants.UserErrorCode;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Role;
import com.kaizhuo.tiangong.boot.modules.admin.entity.User;
import com.kaizhuo.tiangong.boot.modules.admin.exception.UserException;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.RoleMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.*;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.RoleFilterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleMappingService userRoleMappingService;
    @Autowired
    private IRoleResourceMappingService roleResourceMappingService;
    @Autowired
    private IUserGroupService userGroupService;

    /**
     * 获取指定用户的角色列表
     * @param userId
     * @return
     */
    @Override
    public List<Role> getUserRoles(Long userId) {
        User userInfo = userService.getById(userId);
        if(userInfo == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        List<Role> userRoles = baseMapper.getUserRoles(userId);
        if(userRoles == null){
            userRoles = new ArrayList<>();
        }

        return userRoles;
    }

    /**
     * 获取用户所有角色(包含用户组角色)
     * @param userId
     * @return
     */
    @Override
    public List<Role> getUserAllRoles(Long userId) {
        List<Role> userRoles = getUserRoles(userId);
        // 获取该用户的用户组列表
        List<Long> userGroupIds = userGroupService.getUserGroupIds(userId);
        if(!CollectionUtils.isEmpty(userGroupIds)){
            // 根据该用户组列表获取对应的角色列表
            List<Role> groupRoles = getGroupRoles(userGroupIds);
            if(!CollectionUtils.isEmpty(groupRoles)){
                userRoles.addAll(groupRoles);
            }
        }

        // 将合并后的集合去重后返回
        return CollectionUtil.distinctList(userRoles);
    }

    @Override
    public List<Long> getUserAllRoleIds(Long userId) {
        // 获取用户的角色ID列表
        List<Long> userRoleIds = baseMapper.getUserRoleIds(userId);

        // 获取用户的用户组ID列表
        List<Long> userGroupIds = userGroupService.getUserGroupIds(userId);
        // 根据用户组ID列表获取对应的角色列表
        if(!CollectionUtils.isEmpty(userGroupIds)){
            List<Role> groupRoles = getGroupRoles(userGroupIds);
            // 将角色列表转换为角色ID列表
            List<Long> groupRoleIds = groupRoles.stream().map(Role::getRoleId).collect(Collectors.toList());
            // 将用户角色ID列表与用户组角色ID列表合并
            userRoleIds.addAll(groupRoleIds);
        }

        // 将合并后的集合去重返回
        return CollectionUtil.distinctList(userRoleIds);
    }

    @Override
    public List<Role> getGroupRoles(List<Long> groupIds) {
        return baseMapper.getGroupRoles(groupIds);
    }

    @Override
    public IPage<Role> getRoles(RoleFilterVo filterVo) {
        return baseMapper.getRoles(convertPageParam(filterVo), filterVo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long roleId) {
        // 管理员角色不可删除
        if(Constants.ADMIN_ROLE_ID.equals(roleId)){
            throw new UserException(UserErrorCode.ADMIN_ROLE_CANNOT_DELETE_ERROR.getCode());
        }

        removeById(roleId);

        // 删除用户角色映射表中该角色的所有关系
        userRoleMappingService.removeByRoleId(roleId);
        // 删除角色资源映射表中该角色的所有关系
        roleResourceMappingService.removeByRoleId(roleId);
    }

    @Override
    public void bindUserRole(Long userId, List<Long> roleIds) {
        User userInfo = userService.getById(userId);
        if(userInfo == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        // 超级管理员无需分配角色
        if(!CollectionUtils.isEmpty(roleIds) && Constants.ADMIN_NAME.equals(userInfo.getUserName())){
            throw new UserException(UserErrorCode.ADMIN_UNWANT_ROLE_ERROR.getCode());
        }

        // 删除用户角色映射表中该用户的所有关系
        userRoleMappingService.removeByUserId(userId);

        // 重新构建新的绑定关系
        userRoleMappingService.bindMapping(userId, roleIds);
    }
}
