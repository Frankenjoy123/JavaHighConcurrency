package com.highcurrency.pattern.worker;

import com.highcurrency.pattern.task.ITask;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public interface IWorker {

    boolean setTask(ITask task);

}