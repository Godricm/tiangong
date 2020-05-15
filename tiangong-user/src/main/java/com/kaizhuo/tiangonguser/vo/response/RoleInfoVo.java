package com.kaizhuo.tiangonguser.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description: 角色信息
 * @author: miaochen
 * @create: 2020-05-15 21:38
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@Data
@ApiModel(value = "角色信息")
public class RoleInfoVo {
    private Long roleId;
    private String roleName;
    private String roleKey;
    private String roleDesc;
    private Date createTime;
    private Date updateTime;
}
