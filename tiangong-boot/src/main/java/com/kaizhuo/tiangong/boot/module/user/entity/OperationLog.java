package com.kaizhuo.tiangong.boot.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangong.boot.module.user.entity
 * @description: 操作日志
 * @author: miaochen
 * @create: 2020-05-15 21:18
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@TableName("sys_operation_log")
@ApiModel(value="OperationLog对象", description="操作日志")
@Data
public class OperationLog extends BaseModel<OperationLog> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty(value = "操作用户ID")
    private Long userId;

    @ApiModelProperty(value = "操作用户名")
    private String username;

    @ApiModelProperty(value = "操作内容")
    private String operationContent;

    @ApiModelProperty(value = "操作时间")
    private Date operationTime;

    @ApiModelProperty(value = "操作ip")
    private String operationIp;

    @ApiModelProperty(value = "操作请求地址")
    private String operationUri;

    @ApiModelProperty(value = "操作请求方式")
    private String operationMethod;

    @ApiModelProperty(value = "操作类型")
    private Integer operationType;

    @ApiModelProperty(value = "操作请求参数json")
    private String operationParams;

    @ApiModelProperty(value = "操作设备")
    private String operationDevice;


    @Override
    protected Serializable pkVal() {
        return this.logId;
    }
}
