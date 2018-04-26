package com.highcurrency.pattern.task;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public interface ITaskManager {

    ITask createTask(String json);

    ITask poll();

    void remove(ITask task);

    void offer(ITask task);

    int getQueueLength();
}
