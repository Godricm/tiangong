package com.kaizhuo.tiangonguser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangonguser.entity.Role;
import com.kaizhuo.tiangonguser.vo.request.RoleFilterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.mapper
 * @description: 角色表Mapper
 * @author: miaochen
 * @create: 2020-05-15 22:49
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getUserRoles(Long userId);

    List<Long> getUserRoleIds(Long userId);

    List<Role> getGroupRoles(@Param("groupIds") List<Long> groupIds);

    IPage<Role> getRoles(Page page, @Param("param")RoleFilterVo filterVo);
}
