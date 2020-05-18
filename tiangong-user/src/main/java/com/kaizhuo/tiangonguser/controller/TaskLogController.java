package com.kaizhuo.tiangonguser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.common.core.base.controller.BaseController;
import com.kaizhuo.common.core.constants.Constants;
import com.kaizhuo.common.core.vo.ResponseVo;
import com.kaizhuo.tiangonguser.constants.Urls;
import com.kaizhuo.tiangonguser.entity.TaskLog;
import com.kaizhuo.tiangonguser.service.TaskLogService;
import com.kaizhuo.tiangonguser.vo.request.TaskLogFilterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tiangong
 * @package: com.kaizhuo.tiangonguser.controller
 * @description: 定时任务日志
 * @author: miaochen
 * @create: 2020-05-18 22:13
 * @copyright: CopyRight (c) 2020
 * @version: 1.0.0
 * @modified: miaochen
 **/
@RestController
@RequestMapping(Urls.ROOT+"taskLog")
@Api(value = "定时任务日志",tags = "定时任务日志")
public class TaskLogController extends BaseController<TaskLogService, TaskLog> {
    @GetMapping("/range")
    @ApiOperation(value = "根据时间范围分页获取列表", notes = "根据时间范围分页获取列表")
    public ResponseVo<IPage<TaskLog>> list(TaskLogFilterVo taskLogFilterVo, TaskLog entity) {
        //查询列表数据
        QueryWrapper<TaskLog> queryWrapper = new QueryWrapper<>(entity);
        if(taskLogFilterVo.getStartTime() != null && taskLogFilterVo.getEndTime() != null){
            queryWrapper = queryWrapper.between(Constants.FIELD_CREATE_TIME, taskLogFilterVo.getStartTime(), taskLogFilterVo.getEndTime());
        }
        IPage<TaskLog> page = bizService.page(
                new Page<>(taskLogFilterVo.getPageNum(), taskLogFilterVo.getPageSize()),
                queryWrapper
        );

        return new ResponseVo<>(page);
    }
}
