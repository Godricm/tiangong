package com.kaizhuo.tiangonguser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaizhuo.common.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.entity
 * @description: 定时任务日志
 * @author: miaochen
 * @create: 2020-05-15 21:30
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/

@TableName("core_task_log")
@ApiModel(value="TaskLog对象", description="定时任务日志")
@JsonIgnoreProperties(value={"update_time","is_del","version"})
@Data
public class TaskLog extends BaseModel<TaskLog> {
    @ApiModelProperty(value = "任务日志ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long taskLogId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "任务组名")
    private String taskGroup;

    @ApiModelProperty(value = "任务描述")
    private String taskDesc;

    @ApiModelProperty(value = "日志信息")
    private String jobMessage;

    @ApiModelProperty(value = "执行状态  0 正常  1  异常")
    private Integer taskStatus;

    @ApiModelProperty(value = "异常信息")
    private String exceptionInfo;

    @Override
    protected Serializable pkVal() {
        return this.taskLogId;
    }
}
