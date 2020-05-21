package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
 * @description: 用户组
 * @author: miaochen
 * @create: 2020-05-14 22:38
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_group")
@ApiModel(value="UserGroup对象", description="用户组")
@Data
public class UserGroup extends BaseModel<UserGroup> {

    private static final long serialVersionUID = 7842691699666208020L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long groupId;

    @ApiModelProperty(value = "用户组名称")
    private String groupName;

    @Override
    protected Serializable pkVal() {
        return this.groupId;
    }

}
