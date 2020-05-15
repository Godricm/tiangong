package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.UserGroupMapping;

import java.io.Serializable;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description:
 * @author: miaochen
 * @create: 2020-05-15 23:41
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserGroupMappingService extends BaseService<UserGroupMapping> {
    void bindMapping(Long groupId, List<Long> userIds);

    void removeByGroupId(Serializable groupId);
}
