package com.kaizhuo.tiangong.boot.module.user.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.vo.request
 * @description: 用户账号相关请求实体
 * @author: miaochen
 * @create: 2020-05-15 22:12
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("用户账号相关请求实体")
@Data
public class UserAccountVo {
    @ApiModelProperty("登录方式  UPL 用户名密码登录  MACL 手机验证码登录")
    @NotNull(message = "登录方式必填")
    private String loginType;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码(请使用32位MD5加密后传输)")
    private String password;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("登录验证码")
    private String authCode;
}
