package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.UserPostMapping;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 用户岗位
 * @author: miaochen
 * @create: 2020-05-15 23:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserPostMappingService extends BaseService<UserPostMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> postIds);
}
