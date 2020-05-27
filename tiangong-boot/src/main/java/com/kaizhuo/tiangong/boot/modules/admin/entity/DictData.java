package com.kaizhuo.tiangong.boot.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kaizhuo.tiangong.boot.framework.controller.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@TableName("core_dict_data")
@ApiModel(value="DictData对象", description="字典数据")
public class DictData extends BaseModel<DictData> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dict_data_id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


    public Long getDictDataId() {
        return dictDataId;
    }

    public void setDictDataId(Long dictDataId) {
        this.dictDataId = dictDataId;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public Integer getDataSort() {
        return dataSort;
    }

    public void setDataSort(Integer dataSort) {
        this.dataSort = dataSort;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.dictDataId;
    }

    @Override
    public String toString() {
        return "DictData{" +
        "dictDataId=" + dictDataId +
        ", dictType=" + dictType +
        ", dataName=" + dataName +
        ", dataValue=" + dataValue +
        ", dataSort=" + dataSort +
        ", isDefault=" + isDefault +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
