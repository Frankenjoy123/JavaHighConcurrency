package com.highcurrency.pattern.task.impl;

import com.highcurrency.pattern.connector.IConnectorListener;
import com.highcurrency.pattern.task.ITask;
import com.highcurrency.pattern.task.ITaskManager;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public class TaskManager implements ITaskManager , IConnectorListener{

    private BlockingQueue<ITask> taskQueue = new ArrayBlockingQueue<ITask>(1000);

    @Override
    public ITask createTask(String json) {

        //解析json，生成task
        ITask task  = new Task();

        return task;
    }

    @Override
    public ITask poll() {
        return taskQueue.poll();
    }

    @Override
    public void remove(ITask task) {
        taskQueue.remove(task);
    }

    @Override
    public void offer(ITask task) {
        taskQueue.offer(task);
    }

    @Override
    public int getQueueLength() {
        return taskQueue.size() - taskQueue.remainingCapacity();
    }

    @Override
    public void doConnectEvent(String json) {
        ITask task  = createTask(json);
        offer(task);
    }
}
