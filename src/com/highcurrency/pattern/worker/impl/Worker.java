package com.highcurrency.pattern.worker.impl;

import com.highcurrency.pattern.task.ITask;
import com.highcurrency.pattern.task.ITaskManager;
import com.highcurrency.pattern.worker.IWorker;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public class Worker implements IWorker , Runnable{

    private ITaskManager taskManager;

    private ITask task;

    @Override
    public boolean setTask(ITask task) {
        this.task = task;
        return true;
    }

    @Override
    public void run() {
        int res = task.doTask();

        if (res == ITask.TASK_DONE){ //完成

        }else if (res == ITask.REDO_TASK){//重做
            taskManager.offer(task);
        }else {//丢弃

        }
    }

}
