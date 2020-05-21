package com.kaizhuo.tiangong.boot.support.core.service;

import com.kaizhuo.tiangong.boot.framework.controller.BaseService;
import com.kaizhuo.tiangong.boot.support.core.entity.Dept;
import com.kaizhuo.tiangong.boot.support.core.vo.response.DeptVo;

import java.util.List;


public interface IDeptService extends BaseService<Dept> {
    List<DeptVo> getTreeDepts();

    List<Dept> getUserDepts(Long userId);

    List<Long> getDeptIdsByParentId(Long parentId);

    void bindUserDept(Long userId, List<Long> deptIds);
}
