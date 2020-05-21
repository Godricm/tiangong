package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
 * @description: UserGroupMapping信息
 * @author: miaochen
 * @create: 2020-05-14 22:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_group_mapping")
@ApiModel(value="UserGroupMapping对象", description="用户与用户组映射")
@Data
public class UserGroupMapping extends BaseModel<UserGroupMapping> {

    private static final long serialVersionUID = 5880274990774148811L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户组ID")
    private Long groupId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;


    @Override
    protected Serializable pkVal() {
        return mappingId;
    }
}
