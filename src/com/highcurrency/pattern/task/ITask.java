package com.highcurrency.pattern.task;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/26.
 */
public interface ITask {

    int TASK_DONE =0;
    int REDO_TASK =1;
    int DROP_TASK =2;

    int doTask();

    ITask getTask();

    int getPriority();

}
