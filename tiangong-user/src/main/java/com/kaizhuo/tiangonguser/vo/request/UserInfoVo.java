package com.kaizhuo.tiangonguser.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 更新用户信息
 * @author: miaochen
 * @create: 2020-05-15 21:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel(value = "更新用户信息")
@Data
public class UserInfoVo {
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("所在城市代码")
    private String city;
    @ApiModelProperty("用户状态 'N' 正常 'L' 锁定")
    private String userStatus;

    @ApiModelProperty("用户角色,多个以逗号分隔")
    private String userRoles;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userDepts;
    @ApiModelProperty("用户部门,多个以逗号分隔")
    private String userPosts;
}
