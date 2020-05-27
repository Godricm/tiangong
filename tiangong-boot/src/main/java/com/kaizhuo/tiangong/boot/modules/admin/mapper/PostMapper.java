package com.kaizhuo.tiangong.boot.modules.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Post;

import java.util.List;

/**
 * <p>
 * 岗位信息 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface PostMapper extends BaseMapper<Post> {

    List<Post> getUserPosts(Long userId);
}
