package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: 系统参数
 * @author: miaochen
 * @create: 2020-05-15 21:27
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_param")
@ApiModel(value="Param对象", description="系统参数")
@Data
public class Param extends BaseModel<Param> {
    @TableId(value = "id", type = IdType.AUTO)
    private Long paramId;

    @ApiModelProperty(value = "参数名称")
    private String paramName;

    @ApiModelProperty(value = "参数键")
    private String paramKey;

    @ApiModelProperty(value = "参数值")
    private String paramValue;

    @ApiModelProperty(value = "参数描述")
    private String paramDesc;

    @ApiModelProperty(value = "是否为系统参数,系统参数不允许修改 1 是 0 否")
    private Boolean systemFlag;

    @Override
    protected Serializable pkVal() {
        return this.paramId;
    }
}
