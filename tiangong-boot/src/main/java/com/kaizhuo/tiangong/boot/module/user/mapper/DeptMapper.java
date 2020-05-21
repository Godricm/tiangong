package com.kaizhuo.tiangong.boot.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.module.user.entity.Dept;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.mapper
 * @description: 信息部门Mapper
 * @author: miaochen
 * @create: 2020-05-15 22:39
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> getUserDepts(Long userId);
}
