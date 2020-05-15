package com.kaizhuo.tiangonguser.vo.response;

import com.kaizhuo.tiangonguser.entity.Dept;
import com.kaizhuo.tiangonguser.entity.Post;
import com.kaizhuo.tiangonguser.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description: 用户信息
 * @author: miaochen
 * @create: 2020-05-15 21:35
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel(value = "用户信息")
@Data
public class UserResponseVo {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 所在城市代码
     */
    @ApiModelProperty(value = "所在城市代码")
    private String city;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date joinTime;
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLogin;
    @ApiModelProperty("用户状态 'N' 正常 'L' 锁定")
    private String userStatus;

    @ApiModelProperty("用户角色列表")
    private List<Role> userRoles;
    @ApiModelProperty("用户部门列表")
    private List<Dept> userDepts;
    @ApiModelProperty("用户岗位列表")
    private List<Post> userPosts;
}
