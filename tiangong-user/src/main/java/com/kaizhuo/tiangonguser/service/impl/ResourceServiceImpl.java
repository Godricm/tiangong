package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.common.core.constants.Constants;
import com.kaizhuo.tiangonguser.constants.UserErrorCode;
import com.kaizhuo.tiangonguser.entity.Resource;
import com.kaizhuo.tiangonguser.entity.Role;
import com.kaizhuo.tiangonguser.entity.User;
import com.kaizhuo.tiangonguser.exception.UserException;
import com.kaizhuo.tiangonguser.mapper.ResourceMapper;
import com.kaizhuo.tiangonguser.service.ResourceService;
import com.kaizhuo.tiangonguser.service.RoleResourceMappingService;
import com.kaizhuo.tiangonguser.service.RoleService;
import com.kaizhuo.tiangonguser.service.UserService;
import com.kaizhuo.tiangonguser.vo.response.ResourceResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: miaochen
 * \* @Date: 2020/5/16
 * \* @Time: 16:27
 * \* To change this template use File | Settings | File Templates.
 * \* @Description:
 * \
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleResourceMappingService roleResourceMappingService;

    @Override
    public List<ResourceResponseVo> getTreeResources() {
        List<Resource> allResources = list(new QueryWrapper<Resource>().orderByDesc("sort").orderByAsc("id"));

        return convertTreeResources(allResources);
    }

    @Override
    public List<ResourceResponseVo> getTreeResourcesByRoleId(Long roleId) {
        List<Resource> resourcesByRoleId = getResourcesByRoleId(roleId);

        return convertTreeResources(resourcesByRoleId);
    }

    @Override
    public List<Resource> getResourcesByRoleId(Long roleId) {
        return getResourcesByRoleIds(Collections.singletonList(roleId));
    }

    @Override
    public List<Resource> getResourcesByRoleIds(List<Long> roleIds) {
        // 如果具备超级管理员角色,则具备所有资源
        if(roleIds.contains(Constants.ADMIN_ROLE_ID)){
            return list();
        }

        return baseMapper.getResources(roleIds);
    }

    @Override
    public List<ResourceResponseVo> getUserTreeResources(Long userId) {
        List<Resource> resourcesByUserId = getResourcesByUserId(userId);

        return convertTreeResources(resourcesByUserId);
    }

    @Override
    public List<Resource> getResourcesByUserId(Long userId) {
        User userInfo = userService.getById(userId);
        if(userInfo == null){
            throw new UserException(UserErrorCode.USER_NOT_EXIST_ERROR.getCode());
        }

        // 超级管理员具备所有资源权限
        if(Constants.ADMIN_NAME.equals(userInfo.getUserName())){
            return list();
        }

        // 根据用户ID查出所有角色ID
        List<Long> userRoleIds = roleService.getUserAllRoleIds(userId);

        if(CollectionUtils.isEmpty(userRoleIds)){
            return new ArrayList<>();
        }

        // 查出菜单资源列表
        List<Resource> resources = getResourcesByRoleIds(userRoleIds);
        return resources;
    }

    @Override
    public ResourceResponseVo getResourceInfo(Long resourceId) {
        Resource resource = getById(resourceId);
        ResourceResponseVo resourceVo = new ResourceResponseVo();

        if(resource != null){
            List<Resource> allResources = list();
            BeanUtils.copyProperties(resource, resourceVo);
            resourceVo.setChildResources(getChildTreeResources(allResources, resourceId));
        }

        return resourceVo;
    }

    @Override
    public List<Resource> getResourceByParentId(Long parentResourceId) {
        List<Resource> resources = list(new QueryWrapper<Resource>().eq("parent_resource_id", parentResourceId));

        return resources;
    }

    @Override
    public void bindRoleResource(Long roleId, List<Long> resourceIds) {
        Role roleInfo = roleService.getById(roleId);
        if(roleInfo == null){
            throw new UserException(UserErrorCode.ROLE_NOT_EXIST_ERROR.getCode());
        }

        // 删除角色映射表中该角色的所有关系
        roleResourceMappingService.removeByRoleId(roleId);

        // 所有角色都必须有首页权限
        if(!resourceIds.contains(Constants.INDEX_ROOT_RESOURCE_ID)){
            resourceIds.add(Constants.INDEX_ROOT_RESOURCE_ID);
        }
        if(!resourceIds.contains(Constants.INDEX_RESOURCE_ID)){
            resourceIds.add(Constants.INDEX_RESOURCE_ID);
        }
        if(!resourceIds.contains(Constants.DASHBOARD_RESOURCE_ID)){
            resourceIds.add(Constants.DASHBOARD_RESOURCE_ID);
        }

        // 重新构建新的绑定关系
        roleResourceMappingService.bindMapping(roleId, resourceIds);
    }

    @Override
    public void deleteById(Long resourceId) {
        // 如果存在下级资源,则不可删除
        List<Resource> childResources = getResourceByParentId(resourceId);
        if(!CollectionUtils.isEmpty(childResources)){
            throw new UserException(UserErrorCode.RESOURCE_CHILD_NOT_EMPTY_ERROR.getCode());
        }

        removeById(resourceId);

        // 删除角色资源映射表中该资源的所有关系
        roleResourceMappingService.removeByResourceId(resourceId);
    }

    @Override
    public boolean updateById(Resource entity) {
        Long parentResourceId = entity.getParentResourceId();
        Long resourceId = entity.getResourceId();

        Resource resource = getById(resourceId);

        // 如果父类资源等级小于等于当前资源等级,则拒绝更新
        if(parentResourceId != null){
            // 父级分类不能为自己
            if(resourceId.equals(parentResourceId)){
                throw new UserException(UserErrorCode.RESOURCE_CANNOT_SELF_ERROR.getCode());
            }
            Resource parentResource = getById(parentResourceId);
            if(parentResource == null){
                throw new UserException(UserErrorCode.RESOURCE_PARENT_NOT_EXIST_ERROR.getCode());
            }

            Integer parentResourceLevel = parentResource.getResourceLevel();
            if(parentResourceLevel != null){
                if(resource.getResourceLevel() == null || resource.getResourceLevel() < parentResourceLevel){
                    throw new UserException(UserErrorCode.RESOURCE_LEVEL_ERROR.getCode());
                }
                entity.setResourceLevel(parentResourceLevel + 1);
            }
        } else {
            entity.setResourceLevel(0);
        }

        return super.updateById(entity);
    }


    @Override
    public boolean save(Resource entity) {
        Long parentResourceId = entity.getParentResourceId();
        if(parentResourceId == null){
            entity.setParentResourceId(Constants.INDEX_ROOT_RESOURCE_ID);
            parentResourceId = entity.getParentResourceId();
        }

        Resource parentResource = getById(parentResourceId);
        if(parentResource != null){
            Integer parentResourceLevel = parentResource.getResourceLevel();
            if(parentResourceLevel != null){
                entity.setResourceLevel(parentResourceLevel + 1);
            }
        }

        return super.save(entity);
    }

    /**
     * 将一组资源数据转换为树状结构的数据
     * @param resources
     * @return
     */
    private List<ResourceResponseVo> convertTreeResources(List<Resource> resources){
        List<ResourceResponseVo> resourceVos = new ArrayList<>();

        // 筛选出顶级资源,剩余的资源皆为非顶级资源
        if(!CollectionUtils.isEmpty(resources)){
            Iterator<Resource> iterator = resources.iterator();
            while (iterator.hasNext()){
                Resource resource = iterator.next();
                Long parentResourceId = resource.getParentResourceId();
                if(parentResourceId == null || parentResourceId == 0){
                    ResourceResponseVo resourceVo = new ResourceResponseVo();
                    BeanUtils.copyProperties(resource, resourceVo);
                    resourceVo.setChildResources(getChildTreeResources(resources, resource.getResourceId()));
                    resourceVos.add(resourceVo);
                    iterator.remove();
                }
            }
        }

        return resourceVos;
    }

    /**
     * 获取指定父资源ID的数据
     * @param resources
     * @param parentResourceId
     * @return
     */
    private List<ResourceResponseVo> getChildTreeResources(List<Resource> resources, Long parentResourceId){
        if(CollectionUtils.isEmpty(resources)){
            return null;
        }

        List<ResourceResponseVo> treeResources = new ArrayList<>();

        for (Resource resource : resources) {
            Long resourceId = resource.getResourceId();
            Long childParentResourceId = resource.getParentResourceId();
            if (childParentResourceId != null && childParentResourceId.equals(parentResourceId)) {
                ResourceResponseVo responseVo = new ResourceResponseVo();
                BeanUtils.copyProperties(resource, responseVo);
                responseVo.setChildResources(getChildTreeResources(resources, resourceId));
                treeResources.add(responseVo);
            }
        }

        return treeResources;
    }
}
