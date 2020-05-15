package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: 用户角色映射
 * @author: miaochen
 * @create: 2020-05-15 19:57
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_role_mapping")
@ApiModel(value = "UserRoleMapping对象", description = "用户角色映射")
@Data
public class UserRoleMapping extends BaseModel<UserRoleMapping> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    private Long userId;

    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.mappingId;
    }


}
