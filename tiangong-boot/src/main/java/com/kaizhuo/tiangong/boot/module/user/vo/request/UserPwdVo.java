package com.kaizhuo.tiangong.boot.module.user.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.vo.request
 * @description: 修改用户密码
 * @author: miaochen
 * @create: 2020-05-15 22:13
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("修改用户密码")
@Data
public class UserPwdVo {
    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID为必填")
    private Long userId;
    @ApiModelProperty("密码(请使用32位MD5加密后传输)")
    @NotEmpty(message = "请输入密码")
    private String password;
}
