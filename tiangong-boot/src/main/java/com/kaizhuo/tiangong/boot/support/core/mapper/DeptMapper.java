package com.kaizhuo.tiangong.boot.support.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.support.core.entity.Dept;

import java.util.List;

/**
 * <p>
 * 部门信息 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> getUserDepts(Long userId);
}
