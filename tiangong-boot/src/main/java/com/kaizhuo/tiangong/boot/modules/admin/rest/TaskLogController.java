package com.kaizhuo.tiangong.boot.modules.admin.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaizhuo.tiangong.boot.modules.admin.constants.Urls;
import com.kaizhuo.tiangong.boot.framework.controller.BaseController;
import com.kaizhuo.tiangong.boot.framework.vo.ResponseVo;
import com.kaizhuo.tiangong.boot.modules.admin.entity.TaskLog;
import com.kaizhuo.tiangong.boot.modules.admin.service.ITaskLogService;
import com.kaizhuo.tiangong.boot.modules.admin.vo.request.TaskLogFilterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(Urls.ROOT+"/taskLog")
@Api(value = "定时任务日志相关", tags = "定时任务日志相关")
public class TaskLogController extends BaseController<ITaskLogService, TaskLog> {
    @RequestMapping(value = Urls.TASK_LOG_RANGE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "根据时间范围分页获取列表", notes = "根据时间范围分页获取列表")
    @ResponseBody
    public ResponseVo<IPage<TaskLog>> list(TaskLogFilterVo taskLogFilterVo, TaskLog entity) {
        //查询列表数据
        QueryWrapper<TaskLog> queryWrapper = new QueryWrapper<>(entity);
        if(taskLogFilterVo.getStartTime() != null && taskLogFilterVo.getEndTime() != null){
            queryWrapper = queryWrapper.between("ct", taskLogFilterVo.getStartTime(), taskLogFilterVo.getEndTime());
        }
        IPage<TaskLog> page = bizService.page(
                new Page<>(taskLogFilterVo.getPageNum(), taskLogFilterVo.getPageSize()),
                queryWrapper
        );

        return new ResponseVo<>(page);
    }
}

