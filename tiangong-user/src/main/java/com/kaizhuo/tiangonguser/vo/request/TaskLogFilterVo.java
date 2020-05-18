package com.kaizhuo.tiangonguser.vo.request;

import com.kaizhuo.common.core.vo.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.vo.request
 * @description: 定时任务过滤实体
 * @author: miaochen
 * @create: 2020-05-15 22:17
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@ApiModel("定时任务日志过滤实体")
@Data
public class TaskLogFilterVo extends PageRequest {
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
