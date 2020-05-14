package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: 系统角色
 * @author: miaochen
 * @create: 2020-05-14 22:50
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_role")
@ApiModel(value="Role对象", description="角色信息")
@Data
public class SysRole extends BaseModel<SysRole> {

    private static final long serialVersionUID = -4328292604517128823L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色权限标识")
    private String roleKey;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT,value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    @TableField(value = "is_del")
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName=" + roleName +
                ", roleKey=" + roleKey +
                ", roleDesc=" + roleDesc +
                ", ct=" + createTime +
                ", ut=" + updateTime +
                ", isDel=" + isDel +
                ", version=" + version +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole role = (SysRole) o;
        return roleId.equals(role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }
}
