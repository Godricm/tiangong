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
 * @description: 字典目录
 * @author: miaochen
 * @create: 2020-05-15 21:20
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_dict_catalog")
@ApiModel(value="DictCatalog对象", description="字典目录")
@Data
public class DictCatalog extends BaseModel<DictCatalog> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long dictId;

    @ApiModelProperty(value = "字典名称")
    private String dictName;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "状态（0正常 1禁用）")
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return this.dictId;
    }

}
