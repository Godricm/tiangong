package com.kaizhuo.tiangong.boot.modules.admin.service.impl;

import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.modules.admin.constants.UserErrorCode;
import com.kaizhuo.tiangong.boot.modules.admin.entity.UserGroup;
import com.kaizhuo.tiangong.boot.modules.admin.exception.UserException;
import com.kaizhuo.tiangong.boot.modules.admin.mapper.UserGroupMapper;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserGroupMappingService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserGroupRoleMappingService;
import com.kaizhuo.tiangong.boot.modules.admin.service.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroupMapper, UserGroup> implements IUserGroupService {
    @Autowired
    private IUserGroupMappingService userGroupMappingService;
    @Autowired
    private IUserGroupRoleMappingService userGroupRoleMappingService;

    @Override
    @Transactional
    public void bindUsers(Long groupId, List<Long> userIds) {
        UserGroup userGroup = getById(groupId);
        if(userGroup == null){
            throw new UserException(UserErrorCode.USER_GROUP_NOT_EXIST_ERROR.getCode());
        }

        userGroupMappingService.removeByGroupId(groupId);
        userGroupMappingService.bindMapping(groupId, userIds);
    }

    @Override
    @Transactional
    public void bindRoles(Long groupId, List<Long> roleIds) {
        userGroupRoleMappingService.removeByGroupId(groupId);
        userGroupRoleMappingService.bindMapping(groupId, roleIds);
    }

    @Override
    public List<Long> getUserGroupIds(Long userId) {
        return baseMapper.getUserGroupIds(userId);
    }

    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        userGroupMappingService.removeByGroupId(id);
        userGroupRoleMappingService.removeByGroupId(id);

        return super.removeById(id);
    }
}
