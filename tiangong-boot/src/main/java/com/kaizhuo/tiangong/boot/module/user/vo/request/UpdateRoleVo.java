package com.kaizhuo.tiangong.boot.module.user.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.vo.request
 * @description: 添加/修改角色信息
 * @author: miaochen
 * @create: 2020-05-15 22:09
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("添加/修改角色信息")
@Data
public class UpdateRoleVo {
    @ApiModelProperty(value = "角色名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色描述", required = true)
    private String roleDesc;
}
