package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: 用户组角色映射
 * @author: miaochen
 * @create: 2020-05-15 19:25
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_group_role_mapping")
@ApiModel(value = "UserGroupRoleMapping对象",description = "用户组角色映射")
@Data
public class UserGroupRoleMapping extends BaseModel<UserGroupRoleMapping> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户组ID")
    private Long groupId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @Override
    protected Serializable pkVal() {
        return this.mappingId;
    }

}
