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
 * @description: 登录日志
 * @author: miaochen
 * @create: 2020-05-15 21:16
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_login_log")
@ApiModel(value = "LoginLog对象", description = "登录日志")
@Data
public class LoginLog extends BaseModel<LoginLog> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty(value = "登录用户ID")
    private Long loginUserId;

    @ApiModelProperty(value = "登录用户名")
    private String loginUserName;

    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    @ApiModelProperty(value = "登录使用设备")
    private String device;

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

}
