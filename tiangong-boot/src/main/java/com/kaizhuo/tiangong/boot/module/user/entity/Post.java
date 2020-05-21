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
 * @description: 岗位信息
 * @author: miaochen
 * @create: 2020-05-15 21:29
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_post")
@ApiModel(value="Post对象", description="岗位信息")
@Data
public class Post extends BaseModel<Post> {

    @ApiModelProperty(value = "岗位ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long postId;

    @ApiModelProperty(value = "岗位编码")
    private String postCode;

    @ApiModelProperty(value = "岗位名称")
    private String postName;

    @ApiModelProperty(value = "显示顺序")
    private Integer postSort;

    @ApiModelProperty(value = "备注")
    private String remark;

    @Override
    protected Serializable pkVal() {
        return this.postId;
    }
}
