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
 * @description: 部门信息
 * @author: miaochen
 * @create: 2020-05-14 22:47
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_dept")
@ApiModel(value="Dept对象", description="部门信息")
@Data
public class Dept extends BaseModel<Dept> {

    private static final long serialVersionUID = -5922109865264990306L;
    @ApiModelProperty(value = "部门id")
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;

    @TableField(strategy = FieldStrategy.IGNORED)
    @ApiModelProperty(value = "父部门id")
    private Long parentId;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "显示顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "负责人")
    private String leader;

    @ApiModelProperty(value = "部门等级")
    private Integer level;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

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
        return this.deptId;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", parentId=" + parentId +
                ", deptName=" + deptName +
                ", orderNum=" + orderNum +
                ", leader=" + leader +
                ", phone=" + phone +
                ", email=" + email +
                ", ct=" + createTime +
                ", ut=" + updateTime +
                ", isDel=" + isDel +
                ", version=" + version +
                "}";
    }
}
