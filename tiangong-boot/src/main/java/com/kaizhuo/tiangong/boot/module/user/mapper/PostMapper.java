package com.kaizhuo.tiangong.boot.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.module.user.entity.Post;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.mapper
 * @description: 岗位Mapper
 * @author: miaochen
 * @create: 2020-05-15 22:46
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface PostMapper extends BaseMapper<Post> {
    List<Post> getUserPosts(Long userId);
}
