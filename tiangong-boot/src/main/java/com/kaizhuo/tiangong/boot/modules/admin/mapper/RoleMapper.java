package com.kaizhuo.tiangong.boot.modules.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Role;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.RoleFilterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 核心服务-角色表 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getUserRoles(Long userId);

    List<Long> getUserRoleIds(Long userId);

    List<Role> getGroupRoles(@Param("groupIds") List<Long> groupIds);

    IPage<Role> getRoles(Page page, @Param("param") RoleFilterVo filterVo);
}
