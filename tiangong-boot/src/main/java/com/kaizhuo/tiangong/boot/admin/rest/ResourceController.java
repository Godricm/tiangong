
package com.kaizhuo.tiangong.boot.admin.rest;

import com.kaizhuo.tiangong.boot.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.common.util.ConvertUtil;
import com.kaizhuo.tiangong.boot.framework.constants.CoreErrorCode;
import com.kaizhuo.tiangong.boot.framework.exception.BaseException;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.support.core.entity.Resource;
import com.kaizhuo.tiangong.boot.support.core.service.IResourceService;
import com.kaizhuo.tiangong.boot.support.core.vo.request.UpdateResourceVo;
import com.kaizhuo.tiangong.boot.support.core.vo.response.ResourceResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 
@RestController
@RequestMapping(Urls.RESOURCE_MODULE)
@Api(value = "用户资源相关", tags = "用户资源相关")
public class ResourceController {
    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = Urls.RESOURCE_LIST_BY_USER, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定用户的树状结构资源列表", notes = "获取指定用户的树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getUserResources(@PathVariable("userId") Long userId){
        List<ResourceResponseVo> userResources = resourceService.getUserTreeResources(userId);
        return new ResponseVo<>(userResources);
    }

    @RequestMapping(value = Urls.RESOURCE_LIST_BY_ROLE, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定角色的树状结构资源列表", notes = "获取指定角色的树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getRoleResources(@PathVariable("roleId") Long roleId){
        List<ResourceResponseVo> roleResources = resourceService.getTreeResourcesByRoleId(roleId);
        return new ResponseVo<>(roleResources);
    }

    @RequestMapping(value = Urls.RESOURCE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "获取树状结构资源列表", notes = "获取树状结构资源列表")
    public ResponseVo<List<ResourceResponseVo>> getResources(){
        List<ResourceResponseVo> resources = resourceService.getTreeResources();
        return new ResponseVo<>(resources);
    }

    @RequestMapping(value = Urls.RESOURCE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "更新指定资源", notes = "更新指定资源")
    public ResponseVo updateResource(@PathVariable("resourceId") Long resourceId, UpdateResourceVo updateResourceVo){
        Resource resource = new Resource();
        resource.setResourceId(resourceId);
        BeanUtils.copyProperties(updateResourceVo, resource);
        resourceService.updateById(resource);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.RESOURCE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定资源", notes = "删除指定资源")
    public ResponseVo deleteResource(@PathVariable("resourceId") Long resourceId){
        resourceService.deleteById(resourceId);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.RESOURCE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "新增资源", notes = "新增资源")
    public ResponseVo addResource(UpdateResourceVo updateResourceVo){
        if(StringUtils.isEmpty(updateResourceVo.getResourceName())){
            throw new BaseException(CoreErrorCode.REQUIRED_PARAM_EMPTY.getCode());
        }

        Resource resource = new Resource();
        BeanUtils.copyProperties(updateResourceVo, resource);
        resourceService.save(resource);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.RESOURCE_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "获取指定资源详情", notes = "获取指定资源详情")
    public ResponseVo<ResourceResponseVo> getResourceInfo(@PathVariable("resourceId") Long resourceId){
        ResourceResponseVo resourceInfo = resourceService.getResourceInfo(resourceId);
        return new ResponseVo<>(resourceInfo);
    }

    @RequestMapping(value = Urls.RESOURCE_USER_BIND, method = RequestMethod.PUT)
    @ApiOperation(value = "绑定指定角色的资源", notes = "绑定指定角色的资源")
    public ResponseVo bindRoleResource(@PathVariable("roleId") Long roleId, @ApiParam(value = "要绑定的资源ID,多个以英文逗号分隔", required = true) @RequestParam(value = "resourceIds") String resourceIds){
        List<Long> resourceIdList = ConvertUtil.splitStr2LongList(resourceIds, ",");
        resourceService.bindRoleResource(roleId, resourceIdList);
        return new ResponseVo<>();
    }
}
