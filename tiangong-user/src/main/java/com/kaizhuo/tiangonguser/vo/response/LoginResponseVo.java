package com.kaizhuo.tiangonguser.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description: 登录成功用户信息
 * @author: miaochen
 * @create: 2020-05-15 21:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel(value = "登录成功用户信息")
@Data
public class LoginResponseVo {
    @ApiModelProperty(value = "用户身份令牌")
    private String userToken;
    @ApiModelProperty(value = "用户信息")
    private UserResponseVo userInfo;
}
