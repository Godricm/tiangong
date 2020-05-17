package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.UserRoleMapping;
import com.kaizhuo.tiangonguser.mapper.UserRoleMappingMapper;
import com.kaizhuo.tiangonguser.service.UserRoleMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:50
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserRoleMappingServiceImpl extends BaseServiceImpl<UserRoleMappingMapper, UserRoleMapping> implements UserRoleMappingService {
    @Override
    public void removeByRoleId(Long roleId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("role_id", roleId));
    }

    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> roleIds) {
        List<UserRoleMapping> userRoleMappings = new ArrayList<>();
        for(Long roleId : roleIds){
            UserRoleMapping mapping = new UserRoleMapping();
            mapping.setUserId(userId);
            mapping.setRoleId(roleId);
            userRoleMappings.add(mapping);
        }
        saveBatch(userRoleMappings);
    }
}
