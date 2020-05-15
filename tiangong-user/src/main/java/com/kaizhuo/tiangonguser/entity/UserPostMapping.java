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
 * @description:用户岗位映射
 * @author: miaochen
 * @create: 2020-05-15 23:12
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/

@TableName("sys_user_post_mapping")
@ApiModel(value="UserPostMapping对象", description="用户岗位映射")
@Data
public class UserPostMapping extends BaseModel<UserPostMapping> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long mappingId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "岗位ID")
    private Long postId;

    @Override
    protected Serializable pkVal() {
        return this.mappingId;
    }
}
