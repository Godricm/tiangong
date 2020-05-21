 
package com.kaizhuo.tiangong.boot.admin.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kaizhuo.tiangong.boot.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.common.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.support.core.entity.Role;
import com.kaizhuo.tiangong.boot.support.core.service.IRoleService;
import com.kaizhuo.tiangong.boot.support.core.vo.request.RoleFilterVo;
import com.kaizhuo.tiangong.boot.support.core.vo.request.UpdateRoleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
 
@RestController
@RequestMapping(Urls.ROLE_MODULE)
@Api(value = "用户角色相关", tags = "用户角色相关")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = Urls.ROLE_LIST_BY_USER, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定用户的角色列表", notes = "获取指定用户的角色列表")
    public ResponseVo<List<Role>> getUserRoles(@PathVariable("userId") Long userId){
        return new ResponseVo<>(roleService.getUserRoles(userId));
    }

    @RequestMapping(value = Urls.ROLE_LIST_BY_GROUP, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户组关联角色列表", notes = "获取用户组关联角色列表")
    @ResponseBody
    public ResponseVo<List<Role>> getRoles(@PathVariable Long groupId) {

        List<Role> groupRoles = roleService.getGroupRoles(Collections.singletonList(groupId));
        return new ResponseVo<>(groupRoles);
    }

    @RequestMapping(value = Urls.ROLE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    public ResponseVo<IPage<Role>> getUserRoles(RoleFilterVo filterVo){
        return new ResponseVo<>(roleService.getRoles(filterVo));
    }

    @RequestMapping(value = Urls.ROLE_ALL, method = RequestMethod.GET)
    @ApiOperation(value = "获取所有角色列表", notes = "获取所有角色列表")
    public ResponseVo<List<Role>> getUserRoles(Role role){
        return new ResponseVo<>(roleService.list(new QueryWrapper<>(role)));
    }

    @RequestMapping(value = Urls.ROLE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "新增角色", notes = "新增角色")
    public ResponseVo addRole(UpdateRoleVo roleVo){
        if(StringUtils.isEmpty(roleVo.getRoleName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        roleService.save(role);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ROLE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "编辑角色", notes = "编辑角色")
    public ResponseVo updateRole(@PathVariable("roleId") Long roleId, UpdateRoleVo roleVo){
        if(StringUtils.isEmpty(roleVo.getRoleName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Role role = new Role();
        BeanUtils.copyProperties(roleVo, role);
        role.setRoleId(roleId);

        roleService.updateById(role);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ROLE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public ResponseVo deleteRole(@PathVariable("roleId") Long roleId){
        roleService.deleteById(roleId);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ROLE_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "获取角色详情", notes = "获取角色详情")
    public ResponseVo<Role> getRoleInfo(@PathVariable("roleId") Long roleId){

        return new ResponseVo<>(roleService.getById(roleId));
    }

    @RequestMapping(value = Urls.ROLE_USER_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定指定用户的角色", notes = "绑定指定用户的角色")
    public ResponseVo bindUserRole(@PathVariable("userId") Long userId, @ApiParam(value = "要绑定的角色ID,多个以英文逗号分隔", required = true) @RequestParam(value = "roleIds") String roleIds){
        List<Long> roleIdList = ConvertUtil.splitStr2LongList(roleIds, ",");
        roleService.bindUserRole(userId, roleIdList);
        return new ResponseVo<>();
    }

}
