package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: UserGroupMapping信息
 * @author: miaochen
 * @create: 2020-05-14 22:43
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_user_group_mapping")
@ApiModel(value="UserGroupMapping对象", description="用户与用户组映射")
@Data
public class SysUserGroupMapping extends BaseModel<SysUserGroupMapping> {

    private static final long serialVersionUID = 5880274990774148811L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户组ID")
    private Long groupId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

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
        return mappingId;
    }
    @Override
    public String toString() {
        return "UserGroupMapping{" +
                "mappingId=" + mappingId +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", ct=" + createTime +
                ", ut=" + updateTime +
                ", isDel=" + isDel +
                ", version=" + version +
                "}";
    }
}
