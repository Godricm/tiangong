package com.kaizhuo.tiangong.boot.modules.admin.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.modules.admin.entity.Resource;
import com.kaizhuo.tiangong.boot.modules.admin.vo.response.ResourceResponseVo;

import java.util.List;

public interface IResourceService extends BaseService<Resource> {
    List<ResourceResponseVo> getTreeResources();

    List<ResourceResponseVo> getTreeResourcesByRoleId(Long roleId);

    List<Resource> getResourcesByRoleId(Long roleId);

    List<Resource> getResourcesByRoleIds(List<Long> roleIds);

    List<ResourceResponseVo> getUserTreeResources(Long userId);

    List<Resource> getResourcesByUserId(Long userId);

    ResourceResponseVo getResourceInfo(Long resourceId);

    List<Resource> getResourceByParentId(Long parentResourceId);

    void bindRoleResource(Long roleId, List<Long> resourceIds);

    void deleteById(Long resourceId);

}
