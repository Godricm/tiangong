package com.kaizhuo.tiangong.boot.module.user.vo.request;

import com.kaizhuo.tiangong.boot.core.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.vo.request
 * @description: 用户筛选
 * @author: miaochen
 * @create: 2020-05-15 21:48
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("用户筛选")
@Data
public class UserFilterVo extends PageRequest {
    @ApiModelProperty("用户名关键字")
    private String userNameKeyword;
    @ApiModelProperty("角色ID")
    private Long roleId;
    @ApiModelProperty("用户组ID")
    private Long groupId;
    @ApiModelProperty("部门ID")
    private Long deptId;
    @ApiModelProperty(value = "部门ID及对应子部门ID集合", hidden = true)
    private List<Long> allDeptIds;
}
