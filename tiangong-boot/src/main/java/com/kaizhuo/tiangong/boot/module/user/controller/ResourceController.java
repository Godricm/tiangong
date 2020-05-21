package com.kaizhuo.tiangong.boot.module.user.controller;

import com.kaizhuo.tiangong.boot.core.base.controller.BaseController;
import com.kaizhuo.tiangong.boot.core.exception.BaseException;
import com.kaizhuo.tiangong.boot.core.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.core.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.module.user.constants.Urls;
import com.kaizhuo.tiangong.boot.module.user.entity.Resource;
import com.kaizhuo.tiangong.boot.module.user.service.ResourceService;
import com.kaizhuo.tiangong.boot.module.user.vo.request.UpdateResourceVo;
import com.kaizhuo.tiangong.boot.module.user.vo.response.ResourceResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.controller
 * @description: 用户资源相关
 * @author: miaochen
 * @create: 2020-05-18 21:25
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"resource")
@Api(value = "用户资源相关",tags = "用户资源相关")
public class ResourceController extends BaseController<ResourceService, Resource> {
    @GetMapping(value = "/{userId}/list")
    @ApiOperation(value = "获取指定用户的树状结构资源列表", notes = "获取指定用户的树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getUserResources(@PathVariable("userId") Long userId){
        List<ResourceResponseVo> userResources = bizService.getUserTreeResources(userId);
        return new ResponseVo<>(userResources);
    }


    @GetMapping(value = "/{roleId}/list")
    @ApiOperation(value = "获取指定角色的树状结构资源列表", notes = "获取指定角色的树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getRoleResources(@PathVariable("roleId") Long roleId){
        List<ResourceResponseVo> roleResources = bizService.getTreeResourcesByRoleId(roleId);
        return new ResponseVo<>(roleResources);
    }


    @GetMapping(value = "/list")
    @ApiOperation(value = "获取树状结构资源列表", notes = "获取树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getResources(){
        List<ResourceResponseVo> resources = bizService.getTreeResources();
        return new ResponseVo<>(resources);
    }

    @GetMapping("/{resourceId}")
    @ApiOperation(value = "更新指定资源", notes = "更新指定资源")
    public ResponseVo updateResource(@PathVariable("resourceId") Long resourceId, UpdateResourceVo updateResourceVo){
        Resource resource = new Resource();
        resource.setResourceId(resourceId);
        BeanUtils.copyProperties(updateResourceVo, resource);
        bizService.updateById(resource);

        return new ResponseVo<>();
    }

    @DeleteMapping(value = "/{resourceId}")
    @ApiOperation(value = "删除指定资源", notes = "删除指定资源")
    public ResponseVo deleteResource(@PathVariable("resourceId") Long resourceId){
        bizService.deleteById(resourceId);

        return new ResponseVo<>();
    }

    @PostMapping(value = "")
    @ApiOperation(value = "新增资源", notes = "新增资源")
    public ResponseVo addResource(UpdateResourceVo updateResourceVo){
        if(StringUtils.isEmpty(updateResourceVo.getResourceName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Resource resource = new Resource();
        BeanUtils.copyProperties(updateResourceVo, resource);
        bizService.save(resource);

        return new ResponseVo<>();
    }

    @GetMapping(value = "/{resourceId}")
    @ApiOperation(value = "获取指定资源详情", notes = "获取指定资源详情")
    public ResponseVo<ResourceResponseVo> getResourceInfo(@PathVariable("resourceId") Long resourceId){
        ResourceResponseVo resourceInfo = bizService.getResourceInfo(resourceId);
        return new ResponseVo<>(resourceInfo);
    }

    @PutMapping(value = "/bind/{roleId}")
    @ApiOperation(value = "绑定指定角色的资源", notes = "绑定指定角色的资源")
    public ResponseVo bindRoleResource(@PathVariable("roleId") Long roleId, @ApiParam(value = "要绑定的资源ID,多个以英文逗号分隔", required = true) @RequestParam(value = "resourceIds") String resourceIds){
        List<Long> resourceIdList = ConvertUtil.splitStr2LongList(resourceIds, ",");
        bizService.bindRoleResource(roleId, resourceIdList);
        return new ResponseVo<>();
    }
}
