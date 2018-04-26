package com.highcurrency.pattern.worker.impl;

import com.highcurrency.pattern.task.ITask;
import com.highcurrency.pattern.task.ITaskManager;
import com.highcurrency.pattern.worker.IWorker;
import com.highcurrency.pattern.worker.IWorkerManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public class WorkerManager implements IWorkerManager , Runnable {

    private ITaskManager taskManager;

    private ExecutorService executorService  = Executors.newFixedThreadPool(100);

    @Override
    public void setTaskManager(ITaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void run() {

        while (true){
            ITask task = taskManager.poll();

            Worker worker  = new Worker();
            worker.setTask(task);

            executorService.submit(worker);
        }
    }
}
