package com.kaizhuo.tiangong.boot.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.module.user.entity.User;
import com.kaizhuo.tiangong.boot.module.user.vo.request.UserFilterVo;
import com.kaizhuo.tiangong.boot.module.user.vo.response.UserResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.mapper
 * @description: 核心服务-用户表Mapper
 * @author: miaochen
 * @create: 2020-05-15 21:33
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface UserMapper extends BaseMapper<User> {
    User findByUserName(String userName);

    IPage<UserResponseVo> getUserList(Page page, @Param("param")UserFilterVo userFilterVo);

    List<User> getUserByGroupId(Long groupId);
}
