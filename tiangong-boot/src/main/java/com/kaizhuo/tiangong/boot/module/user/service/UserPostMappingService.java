package com.kaizhuo.tiangong.boot.module.user.service;

import com.kaizhuo.tiangong.boot.core.base.service.BaseService;
import com.kaizhuo.tiangong.boot.module.user.entity.UserPostMapping;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.service
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
