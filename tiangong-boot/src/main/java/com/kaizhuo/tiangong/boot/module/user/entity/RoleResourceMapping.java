package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
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
