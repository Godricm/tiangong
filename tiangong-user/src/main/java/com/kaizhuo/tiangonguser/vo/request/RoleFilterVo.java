package com.kaizhuo.tiangonguser.vo.request;

import com.kaizhuo.common.core.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 角色过滤实体
 * @author: miaochen
 * @create: 2020-05-15 22:13
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("角色过滤实体")
public class RoleFilterVo extends PageRequest {
    @ApiModelProperty("角色名关键字")
    private String roleNameKeyword;
}
