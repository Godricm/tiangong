package com.kaizhuo.tiangong.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaizhuo.tiangong.boot.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.mapper
 * @description:
 * @author: miaochen
 * @create: 2020-05-04 17:35
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
}
