package com.kaizhuo.tiangong.boot.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@TableName("core_user_group")
@ApiModel(value="UserGroup对象", description="用户组")
public class UserGroup extends BaseModel<UserGroup> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "group_id", type = IdType.AUTO)
    private Long groupId;

    @ApiModelProperty(value = "用户组名称")
    private String groupName;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        return this.groupId;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
        "groupId=" + groupId +
        ", groupName=" + groupName +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
