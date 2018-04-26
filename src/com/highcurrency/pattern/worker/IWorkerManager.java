package com.highcurrency.pattern.worker;

import com.highcurrency.pattern.task.ITaskManager;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public interface IWorkerManager {

    void setTaskManager(ITaskManager taskManager);
}
