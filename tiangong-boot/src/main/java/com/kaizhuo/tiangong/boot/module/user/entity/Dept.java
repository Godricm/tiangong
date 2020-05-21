package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
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

    @Override
    protected Serializable pkVal() {
        return this.deptId;
    }

}
