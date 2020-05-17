package com.kaizhuo.tiangonguser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaizhuo.common.core.base.service.BaseServiceImpl;
import com.kaizhuo.tiangonguser.constants.UserErrorCode;
import com.kaizhuo.tiangonguser.entity.Dept;
import com.kaizhuo.tiangonguser.exception.UserException;
import com.kaizhuo.tiangonguser.mapper.DeptMapper;
import com.kaizhuo.tiangonguser.service.DeptService;
import com.kaizhuo.tiangonguser.service.UserDeptMappingService;
import com.kaizhuo.tiangonguser.vo.response.DeptVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service.impl
 * @description: 部门信息服务
 * @author: miaochen
 * @create: 2020-05-15 23:20
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Service
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements DeptService {

    @Autowired
    UserDeptMappingService userDeptMappingService;

    @Override
    public List<DeptVo> getTreeDepts() {
       List<Dept> depts=list();

        return convertTreeDepts(depts);
    }

    @Override
    public List<Dept> getUserDepts(Long userId) {
        List<Dept> depts=baseMapper.getUserDepts(userId);
        return depts;
    }

    @Override
    public List<Long> getDeptIdsByParentId(Long parentId) {
        List<Dept> depts=list(); 
        return getChildTreeDeptIds(depts,parentId);
    }

    @Override
    public void bindUserDept(Long userId, List<Long> deptIds) {
        userDeptMappingService.removeByUserId(userId);
        userDeptMappingService.bindMapping(userId,deptIds);

    }

    @Override
    public boolean updateById(Dept entity) {
        //check验证
        Long parentDeptId = entity.getParentId();
        Long deptId = entity.getDeptId();
        Dept dept = getById(deptId);

        // 如果父类等级小于等于当前等级,则拒绝更新
        if(parentDeptId != null){
            // 父级分类不能为自己
            if(deptId.equals(parentDeptId)){
                throw new UserException(UserErrorCode.DEPT_CANNOT_SELF_ERROR.getCode());
            }
            Dept parentDept = getById(parentDeptId);
            if(parentDept == null){
                throw new UserException(UserErrorCode.DEPT_PARENT_NOT_EXIST_ERROR.getCode());
            }

            Integer parentDeptLevel = parentDept.getLevel();
            if(parentDeptLevel != null){
                if(dept.getLevel() == null || dept.getLevel() < parentDeptLevel){
                    throw new UserException(UserErrorCode.DEPT_LEVEL_ERROR.getCode());
                }
                entity.setLevel(parentDeptLevel + 1);
            }
        } else {
            entity.setLevel(0);
        }

        return super.updateById(entity);
    }

    @Override
    public boolean save(Dept entity) {
        // 添加前填充分类等级字段
        Long parentId = entity.getParentId();
        if(parentId != null){
            Dept parentDept = getById(parentId);
            if(parentDept == null){
                throw new UserException(UserErrorCode.DEPT_PARENT_NOT_EXIST_ERROR.getCode());
            }

            Integer parentDeptLevel = parentDept.getLevel();
            if(parentDeptLevel != null){
                entity.setLevel(parentDeptLevel + 1);
            }
        }

        return super.save(entity);
    }

    @Override
    public List<Dept> list() {
        return super.list(new QueryWrapper<Dept>().orderByDesc("order_num"));
    }

    private List<DeptVo> convertTreeDepts(List<Dept> depts){
        List<DeptVo> deptVos = new ArrayList<>();

        // 筛选出顶级资源,剩余的资源皆为非顶级资源
        if(!CollectionUtils.isEmpty(depts)){
            Iterator<Dept> iterator = depts.iterator();
            while (iterator.hasNext()){
                Dept dept = iterator.next();
                Long parentDeptId = dept.getParentId();
                if(parentDeptId == null || parentDeptId == 0){
                    DeptVo deptVo = new DeptVo();
                    BeanUtils.copyProperties(dept, deptVo);
                    deptVo.setChildDepts(getChildTreeDepts(depts, dept.getDeptId()));
                    deptVos.add(deptVo);
                    iterator.remove();
                }
            }
        }

        return deptVos;
    }

    /**
     * 获取指定父部门ID的数据
     * @param depts
     * @param parentDeptId
     * @return
     */
    private List<DeptVo> getChildTreeDepts(List<Dept> depts, Long parentDeptId){
        if(CollectionUtils.isEmpty(depts)){
            return null;
        }

        List<DeptVo> treeDepts = new ArrayList<>();

        for (Dept dept : depts) {
            Long deptId = dept.getDeptId();
            Long childParentDeptId = dept.getParentId();
            if (childParentDeptId != null && childParentDeptId.equals(parentDeptId)) {
                DeptVo deptVo = new DeptVo();
                BeanUtils.copyProperties(dept, deptVo);
                deptVo.setChildDepts(getChildTreeDepts(depts, deptId));
                treeDepts.add(deptVo);
            }
        }

        return treeDepts;
    }

    private List<Long> getChildTreeDeptIds(List<Dept> depts, Long parentDeptId){
        if(CollectionUtils.isEmpty(depts)){
            return null;
        }

        List<Long> treeDeptIds = new ArrayList<>();

        for (Dept dept : depts) {
            Long deptId = dept.getDeptId();
            Long childParentDeptId = dept.getParentId();
            if (childParentDeptId != null && childParentDeptId.equals(parentDeptId)) {
                treeDeptIds.add(deptId);

                List<Long> childTreeDeptIds = getChildTreeDeptIds(depts, deptId);
                if(!CollectionUtils.isEmpty(childTreeDeptIds)){
                    treeDeptIds.addAll(childTreeDeptIds);
                }
            }
        }

        return treeDeptIds;
    }
}
