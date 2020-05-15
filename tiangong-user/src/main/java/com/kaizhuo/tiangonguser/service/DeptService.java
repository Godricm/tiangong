package com.kaizhuo.tiangonguser.service;

import com.kaizhuo.common.core.base.service.BaseService;
import com.kaizhuo.tiangonguser.entity.Dept;
import com.kaizhuo.tiangonguser.vo.response.DeptVo;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.service
 * @description: 部门服务
 * @author: miaochen
 * @create: 2020-05-15 23:18
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface DeptService extends BaseService<Dept> {
    List<DeptVo> getTreeDepts();

    List<Dept> getUserDepts(Long userId);

    List<Long> getDeptIdsByParentId(Long parentId);

    void bindUserDept(Long userId,List<Long> deptIds);
}
