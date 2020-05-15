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
 * @description: 资源信息
 * @author: miaochen
 * @create: 2020-05-15 20:16
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_resource")
@ApiModel(value = "Resource对象", description = "资源信息")
@Data
public class Resource extends BaseModel<Resource> {

    private static final long serialVersionUID = 6571611884289379207L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long resourceId;

    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @ApiModelProperty(value = "资源类型(G 菜单组 M 菜单  O 按钮)")
    private String resourceType;

    @ApiModelProperty(value = "资源标识符")
    private String resourceKey;

    @ApiModelProperty(value = "资源路径")
    private String resourceUri;

    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;

    @ApiModelProperty(value = "资源视图")
    private String resourceView;

    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;

    @ApiModelProperty(value = "资源权限标识")
    private String resourcePerms;

    @ApiModelProperty(value = "资源等级")
    private Integer resourceLevel;

    @ApiModelProperty(value = "父级资源ID")
    @TableField(strategy = FieldStrategy.IGNORED)
    private Long parentResourceId;

    @ApiModelProperty(value = "排序")
    private Integer sort;


    @Override
    protected Serializable pkVal() {
        return this.resourceId;
    }
}
