package com.kaizhuo.tiangonguser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangonguser.entity.UserGroup;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.mapper
 * @description: 核心服务-用户组表Mapper接口
 * @author: miaochen
 * @create: 2020-05-15 22:21
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    List<Long> getUserGroupIds(Long userId);
}
