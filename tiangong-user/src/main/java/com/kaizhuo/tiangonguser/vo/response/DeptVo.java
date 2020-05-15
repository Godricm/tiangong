package com.kaizhuo.tiangonguser.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description: 部门信息
 * @author: miaochen
 * @create: 2020-05-15 21:41
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel(value = "部门信息")
@Data
public class DeptVo {
    @ApiModelProperty(value = "部门id")
    private Long deptId;

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

    @ApiModelProperty(value = "子级部门列表")
    private List<DeptVo> childDepts;
}
