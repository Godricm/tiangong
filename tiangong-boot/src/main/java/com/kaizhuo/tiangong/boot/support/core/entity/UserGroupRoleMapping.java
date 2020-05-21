package com.kaizhuo.tiangong.boot.support.core.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@TableName("core_user_group_role_mapping")
@ApiModel(value="UserGroupRoleMapping对象", description="用户组角色映射")
public class UserGroupRoleMapping extends BaseModel<UserGroupRoleMapping> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mapping_id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户组ID")
    private Long groupId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


    public Long getMappingId() {
        return mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.mappingId;
    }

    @Override
    public String toString() {
        return "UserGroupRoleMapping{" +
        "mappingId=" + mappingId +
        ", groupId=" + groupId +
        ", roleId=" + roleId +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
