package com.kaizhuo.tiangonguser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangonguser.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.mapper
 * @description: 资源信息Mapper
 * @author: miaochen
 * @create: 2020-05-15 22:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface ResourceMapper extends BaseMapper<Resource> {
    List<Resource> getSources(@Param("roleIds") List<Long> roleIds);
}
