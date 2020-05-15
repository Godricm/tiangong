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
 * @description: 用户部门映射
 * @author: miaochen
 * @create: 2020-05-15 19:23
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_dept_mapping")
@ApiModel(value="UserDeptMapping对象", description="用户部门映射")
@Data
public class UserDeptMapping extends BaseModel<UserDeptMapping> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "部门id")
    private Long deptId;



    @Override
    protected Serializable pkVal() {
        return this.mappingId;
    }

}
