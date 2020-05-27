package com.kaizhuo.tiangong.boot.modules.quartz.service;


import com.kaizhuo.tiangong.boot.modules.quartz.vo.OptTaskInfo;
import com.kaizhuo.tiangong.boot.modules.quartz.vo.TaskInfo;
import org.quartz.SchedulerException;

import java.util.List;

public interface TaskService {

    List<TaskInfo> list();

    void addJob(OptTaskInfo info);

    void edit(OptTaskInfo info);

    void delete(String jobName, String jobGroup);

    void pause(String jobName, String jobGroup);

    void resume(String jobName, String jobGroup);

    boolean checkExists(String jobName, String jobGroup)throws SchedulerException;
}
