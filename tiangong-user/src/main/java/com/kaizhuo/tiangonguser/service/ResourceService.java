package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.Resource;
import com.kaizhuo.tiangonguser.vo.response.ResourceResponseVo;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 资源服务
 * @author: miaochen
 * @create: 2020-05-15 23:32
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface ResourceService  extends BaseService<Resource> {
    /**
     * 获取资源树形结构
     * @return
     */
    List<ResourceResponseVo> getTreeResources();

    /**
     * 根据角色Id获取资源树形结构
     * @param roleId
     * @return
     */
    List<ResourceResponseVo> getTreeResourcesByRoleId(Long roleId);

    /**
     * 获取角色下所有的资源
     * @param roleId
     * @return
     */
    List<Resource> getResourcesByRoleId(Long roleId);

    /**
     * 获取角色列表下的所有资源
     * @param roleIds
     * @return
     */
    List<Resource> getResourcesByRoleIds(List<Long> roleIds);

    /**
     * 获取用户的资源树形结构
     * @param userId
     * @return
     */
    List<ResourceResponseVo> getUserTreeResources(Long userId);

    /**
     * 获取用户的所有资源
     * @param userId
     * @return
     */
    List<Resource> getResourcesByUserId(Long userId);

    /**
     * 获取指定Id的信息
     * @param resourceId
     * @return
     */
    ResourceResponseVo getResourceInfo(Long resourceId);

    /**
     * 获取某一资源下的信息
     * @param parentResourceId
     * @return
     */
    List<Resource> getResourceByParentId(Long parentResourceId);

    /**
     * 角色设置资源
     * @param roleId
     * @param resourceIds
     */
    void bindRoleResource(Long roleId, List<Long> resourceIds);

    /**
     * 删除
     * @param resourceId
     */
    void deleteById(Long resourceId);
}
