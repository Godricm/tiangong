package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.core.util.CollectionUtil;
import com.kaizhuo.tiangong.boot.module.user.constants.UserErrorCode;
import com.kaizhuo.tiangong.boot.module.user.entity.Role;
import com.kaizhuo.tiangong.boot.module.user.entity.User;
import com.kaizhuo.tiangong.boot.module.user.exception.UserException;
import com.kaizhuo.tiangong.boot.module.user.mapper.RoleMapper;
import com.kaizhuo.tiangong.boot.module.user.service.*;
import com.kaizhuo.tiangong.boot.module.user.vo.request.RoleFilterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:37
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private UserRoleMappingService userRoleMappingService;

    @Autowired
    private RoleResourceMappingService roleResourceMappingService;

    @Override
    public List<Role> getUserRoles(Long userId) {
        User userInfo=userService.getById(userId);
        if(userInfo==null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }
        List<Role> userRoles=baseMapper.getUserRoles(userId);
        if(userRoles==null){
            userRoles=new ArrayList<>();
        }
        return null;
    }

    @Override
    public List<Role> getUserAllRoles(Long userId) {
        List<Role> userRoles=getUserRoles(userId);
        //获取该用户的用户组列表
        List<Long> userGroupIds=userGroupService.getUserGroupIds(userId);
        if(!CollectionUtils.isEmpty(userGroupIds)){
            List<Role> groupRoles=getGroupRoles(userGroupIds);
            if(!CollectionUtils.isEmpty(groupRoles)){
                userRoles.addAll(groupRoles);
            }
        }
        return CollectionUtil.distinctList(userRoles);
    }

    @Override
    public List<Long> getUserAllRoleIds(Long userId) {
        //获取用户的角色ID列表
        List<Long> userRoleIds=baseMapper.getUserRoleIds(userId);
        //获取用户的用户组ID列表
        List<Long> userGroupIds=userGroupService.getUserGroupIds(userId);
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
        return baseMapper.getRoles(convertPageParam(filterVo),filterVo);
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
        User userInfo=userService.getById(userId);
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
