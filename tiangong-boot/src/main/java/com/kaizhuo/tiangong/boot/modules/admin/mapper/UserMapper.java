package com.kaizhuo.tiangong.boot.modules.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.modules.admin.entity.User;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.UserFilterVo;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.UserResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 核心服务-用户表 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUserName(String userName);

    IPage<UserResponseVo> getUserList(Page page, @Param("param") UserFilterVo filterVo);

    List<User> getUserByGroupId(Long groupId);
}
