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
 * @description: 角色资源映射
 * @author: miaochen
 * @create: 2020-05-15 21:12
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_role_resource_mapping")
@ApiModel(value = "RoleResourceMapping对象", description = "角色资源映射")
@Data
public class RoleResourceMapping extends BaseModel<RoleResourceMapping> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long resourceId;

    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
