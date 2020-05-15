package com.kaizhuo.tiangonguser.vo.request;

import com.kaizhuo.common.core.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 资源过滤实体
 * @author: miaochen
 * @create: 2020-05-15 22:14
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("资源过滤实体")
@Data
public class ResourceFilterVo  extends PageRequest {
    @ApiModelProperty("资源名关键字")
    private String resourceNameKeyword;
    @ApiModelProperty(value = "父级资源ID")
    private Long parentResourceId;
    @ApiModelProperty(value = "资源类型(M 菜单  O 按钮)")
    private String resourceType;
}
