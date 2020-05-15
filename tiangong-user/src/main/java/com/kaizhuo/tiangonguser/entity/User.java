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
 * @description: 用户信息
 * @author: miaochen
 * @create: 2020-05-14 22:33
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user")
@ApiModel(value="User对象", description="用户信息")
@Data
public class User extends BaseModel<User> {

    private static final long serialVersionUID = 5434055431241286933L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码", hidden = true)
    private String password;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "注册时间")
    private Date joinTime;

    @ApiModelProperty(value = "最后登录时间")
    private Date lastLogin;

    @ApiModelProperty(value = "用户状态 'N' 正常 'L' 锁定")
    private String userStatus;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
