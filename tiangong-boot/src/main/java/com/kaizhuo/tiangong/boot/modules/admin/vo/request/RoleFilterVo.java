package com.kaizhuo.tiangong.boot.modules.admin.vo.request;

import com.kaizhuo.tiangong.boot.framework.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("角色过滤实体")
public class RoleFilterVo extends PageRequest {
    @ApiModelProperty("角色名关键字")
    private String roleNameKeyword;

    public String getRoleNameKeyword() {
        return roleNameKeyword;
    }

    public void setRoleNameKeyword(String roleNameKeyword) {
        this.roleNameKeyword = roleNameKeyword;
    }
}
