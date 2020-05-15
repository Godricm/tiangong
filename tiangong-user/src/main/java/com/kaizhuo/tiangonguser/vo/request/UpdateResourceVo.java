package com.kaizhuo.tiangonguser.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 添加/修改资源信息
 * @author: miaochen
 * @create: 2020-05-15 21:49
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("添加/修改资源信息")
public class UpdateResourceVo {
    @ApiModelProperty(value = "资源名称", required = true)
    @NotNull
    private String resourceName;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)", required = true)
    @NotNull
    private String resourceType;
    @ApiModelProperty(value = "资源标识符", required = true)
    @NotNull
    private String resourceKey;
    @ApiModelProperty(value = "资源URI")
    private String resourceUri;
    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;
    @ApiModelProperty(value = "资源视图")
    private String resourceView;
    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;
    @ApiModelProperty(value = "父级资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "排序")
    private Integer sort;
}
