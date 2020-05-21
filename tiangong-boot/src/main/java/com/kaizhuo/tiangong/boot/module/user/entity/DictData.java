package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
 * @description: 字典数据
 * @author: miaochen
 * @create: 2020-05-15 21:21
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_dict_data")
@ApiModel(value="DictData对象", description="字典数据")
@Data
public class DictData extends BaseModel<DictData> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long dictDataId;

    @ApiModelProperty(value = "字典类型")
    private String dictType;

    @ApiModelProperty(value = "字典数据名称")
    private String dataName;

    @ApiModelProperty(value = "字典键值")
    private String dataValue;

    @ApiModelProperty(value = "字典排序")
    private Integer dataSort;

    @ApiModelProperty(value = "是否默认值  0  否  1  是")
    private Integer isDefault;

    @Override
    protected Serializable pkVal() {
        return this.dictDataId;
    }

}
