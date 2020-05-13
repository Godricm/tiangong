package com.kaizhuo.common.core.base.model;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.common.core.base.model
 * @description: 基类实体
 * @author: miaochen
 * @create: 2020-05-11 22:17
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@JsonIgnoreProperties(value={"ct","ut","isDel","version"})
public abstract class BaseModel<T extends BaseModel> extends Model<T> {
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    protected Serializable pkVal() {
        return super.pkVal();
    }
}
