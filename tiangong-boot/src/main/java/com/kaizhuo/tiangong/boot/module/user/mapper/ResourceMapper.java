package com.kaizhuo.tiangong.boot.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.module.user.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.mapper
 * @description: 资源信息Mapper
 * @author: miaochen
 * @create: 2020-05-15 22:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
public interface ResourceMapper extends BaseMapper<Resource> {
    List<Resource> getResources(@Param("roleIds") List<Long> roleIds);
}
