package com.kaizhuo.tiangong.boot.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.tiangong.boot.framework.controller.BaseServiceImpl;
import com.kaizhuo.tiangong.boot.support.core.entity.UserDeptMapping;
import com.kaizhuo.tiangong.boot.support.core.mapper.UserDeptMappingMapper;
import com.kaizhuo.tiangong.boot.support.core.service.IUserDeptMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDeptMappingServiceImpl extends BaseServiceImpl<UserDeptMappingMapper, UserDeptMapping> implements IUserDeptMappingService {

    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserDeptMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> deptIds) {
        List<UserDeptMapping> userDeptMappings = new ArrayList<>();
        for(Long deptId : deptIds){
            UserDeptMapping mapping = new UserDeptMapping();
            mapping.setUserId(userId);
            mapping.setDeptId(deptId);
            userDeptMappings.add(mapping);
        }
        saveBatch(userDeptMappings);
    }
}
