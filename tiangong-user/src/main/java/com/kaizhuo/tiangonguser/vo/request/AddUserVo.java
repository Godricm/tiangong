package com.kaizhuo.tiangonguser.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 新增用户
 * @author: miaochen
 * @create: 2020-05-15 23:23
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("新增用户")
@Data
public class AddUserVo {
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "密码(请使用32位MD5加密后传输)", required = true)
    private String password;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("所在城市代码")
    private String city;

    @ApiModelProperty("用户角色,多个以逗号分隔")
    private String userRoles;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userDepts;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userPosts;
}
