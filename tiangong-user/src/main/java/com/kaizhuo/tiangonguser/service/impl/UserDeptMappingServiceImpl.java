package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.entity.UserDeptMapping;
import com.kaizhuo.tiangonguser.mapper.UserDeptMappingMapper;
import com.kaizhuo.tiangonguser.service.UserDeptMappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service.impl
 * @description:
 * @author: miaochen
 * @create: 2020-05-17 20:41
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class UserDeptMappingServiceImpl extends BaseServiceImpl<UserDeptMappingMapper, UserDeptMapping> implements UserDeptMappingService {
    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserDeptMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> deptIds) {
        List<UserDeptMapping> userDeptMappings = new ArrayList<>();
        for (Long deptId : deptIds) {
            UserDeptMapping mapping=new UserDeptMapping();
            mapping.setUserId(userId);
            mapping.setDeptId(deptId);
            userDeptMappings.add(mapping);
        }

        saveBatch(userDeptMappings);
    }
}
