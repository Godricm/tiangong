package com.kaizhuo.tiangong.boot.module.user.service.impl;

import com.kaizhuo.tiangong.boot.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.module.user.constants.UserErrorCode;
import com.kaizhuo.tiangong.boot.module.user.entity.UserGroup;
import com.kaizhuo.tiangong.boot.module.user.exception.UserException;
import com.kaizhuo.tiangong.boot.module.user.mapper.UserGroupMapper;
import com.kaizhuo.tiangong.boot.module.user.service.UserGroupMappingService;
import com.kaizhuo.tiangong.boot.module.user.service.UserGroupRoleMappingService;
import com.kaizhuo.tiangong.boot.module.user.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:30
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {

    @Autowired
    private UserGroupMappingService userGroupMappingService;

    @Autowired
    private UserGroupRoleMappingService userGroupRoleMappingService;

    @Override
    public void bindUsers(Long groupId, List<Long> userIds) {
        UserGroup userGroup=getById(groupId);
        if(userGroup==null){
            throw new UserException(UserErrorCode.USER_GROUP_NOT_EXIST_ERROR.getCode());
        }

        userGroupMappingService.removeByGroupId(groupId);
        userGroupMappingService.bindMapping(groupId,userIds);
    }

    @Override
    public void bindRoles(Long groupId, List<Long> roleIds) {
        UserGroup userGroup=getById(groupId);
        if(userGroup==null){
            throw new UserException(UserErrorCode.USER_GROUP_NOT_EXIST_ERROR.getCode());
        }

        userGroupRoleMappingService.removeByGroupId(groupId);
        userGroupRoleMappingService.bindMapping(groupId,roleIds);
    }

    @Override
    public List<Long> getUserGroupIds(Long userId) {
        return baseMapper.getUserGroupIds(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        userGroupMappingService.removeByGroupId(id);
        userGroupRoleMappingService.removeByGroupId(id);
        return super.removeById(id);
    }
}
