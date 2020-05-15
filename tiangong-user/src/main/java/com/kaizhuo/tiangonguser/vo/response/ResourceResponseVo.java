package com.kaizhuo.tiangonguser.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.response
 * @description:
 * @author: miaochen
 * @create: 2020-05-15 23:33
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("资源信息")
@Data
public class ResourceResponseVo {
    @ApiModelProperty(value = "资源ID")
    private Long resourceId;
    @ApiModelProperty(value = "资源名称")
    private String resourceName;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)")
    private String resourceType;
    @ApiModelProperty(value = "资源路径")
    private String resourceUri;
    @ApiModelProperty(value = "资源重定向")
    private String resourceRedirect;
    @ApiModelProperty(value = "资源视图")
    private String resourceView;
    @ApiModelProperty(value = "资源标识符")
    private String resourceKey;
    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;
    @ApiModelProperty(value = "资源权限标识")
    private String resourcePerms;
    @ApiModelProperty(value = "资源等级 0-99 0为顶级")
    private Integer resourceLevel;
    @ApiModelProperty(value = "父类资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "子级资源列表")
    private List<ResourceResponseVo> childResources;
}
