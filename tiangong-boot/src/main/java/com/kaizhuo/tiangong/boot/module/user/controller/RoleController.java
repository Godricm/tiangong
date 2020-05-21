package com.kaizhuo.tiangong.boot.module.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.core.exception.BaseException;
import com.kaizhuo.tiangong.boot.core.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.core.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.Role;
import com.kaizhuo.tiangong.boot.module.user.service.RoleService;
import com.kaizhuo.tiangong.boot.module.user.vo.request.RoleFilterVo;
import com.kaizhuo.tiangong.boot.module.user.vo.request.UpdateRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
 * @description: 角色信息相关
 * @author: miaochen
 * @create: 2020-05-18 21:41
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"role")
@Api(value = "用户角色相关",tags = "用户角色相关")
public class RoleController extends BaseController<RoleService, Role> {

    @GetMapping("/{userId}/list")
    @ApiOperation(value = "获取指定用户的角色列表",notes = "获取指定用户的角色列表")
    public ResponseVo<List<Role>> getUserRoles(@PathVariable("userId") Long userId){
        List<Role> userRoles=bizService.getUserRoles(userId);
        return new ResponseVo<>(userRoles);
    }

    @GetMapping("/group/{groupId}/list")
    @ApiOperation(value = "获取用户组关联角色列表", notes = "获取用户组关联角色列表")
    public ResponseVo<List<Role>> getRoles(@PathVariable Long groupId) {

        List<Role> groupRoles = bizService.getGroupRoles(Collections.singletonList(groupId));
        return new ResponseVo<>(groupRoles);
    }

    @GetMapping("/page/filter")
    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    public ResponseVo<IPage<Role>> getUserRoles(RoleFilterVo filterVo){
        return new ResponseVo<>(bizService.getRoles(filterVo));
    }

    @GetMapping("/all/filter")
    @ApiOperation(value = "获取所有角色列表", notes = "获取所有角色列表")
    public ResponseVo<List<Role>> getUserRoles(Role role){
        return new ResponseVo<>(bizService.list(new QueryWrapper<>(role)));
    }

    @PostMapping("")
    @ApiOperation(value = "新增角色", notes = "新增角色")
    public ResponseVo addRole(UpdateRoleVo roleVo){
        if(StringUtils.isEmpty(roleVo.getRoleName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        bizService.save(role);

        return new ResponseVo<>();
    }

    @PutMapping("/{roleId}")
    @ApiOperation(value = "编辑角色", notes = "编辑角色")
    public ResponseVo updateRole(@PathVariable("roleId") Long roleId, UpdateRoleVo roleVo){
        if(StringUtils.isEmpty(roleVo.getRoleName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        role.setRoleId(roleId);

        bizService.updateById(role);

        return new ResponseVo<>();
    }

    @DeleteMapping("/{roleId}")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public ResponseVo deleteRole(@PathVariable("roleId") Long roleId){
        bizService.deleteById(roleId);

        return new ResponseVo<>();
    }

    @GetMapping("/{roleId}")
    @ApiOperation(value = "获取角色详情", notes = "获取角色详情")
    public ResponseVo<Role> getRoleInfo(@PathVariable("roleId") Long roleId){

        return new ResponseVo<>(bizService.getById(roleId));
    }

    @PutMapping("/bind/{userId}")
    @ApiOperation(value = "绑定指定用户的角色", notes = "绑定指定用户的角色")
    public ResponseVo bindUserRole(@PathVariable("userId") Long userId, @ApiParam(value = "要绑定的角色ID,多个以英文逗号分隔", required = true) @RequestParam(value = "roleIds") String roleIds){
        List<Long> roleIdList = ConvertUtil.splitStr2LongList(roleIds, ",");
        bizService.bindUserRole(userId, roleIdList);
        return new ResponseVo<>();
    }
}
