package com.highcurrency.pattern.task.impl;

import com.highcurrency.pattern.task.ITask;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public class Task implements ITask {


    @Override
    public int doTask() {

        //todo business job
        return ITask.TASK_DONE;
    }

    @Override
    public ITask getTask() {
        return null;
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
