package com.highcurrency.lock;

import java.awt.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/8/27.
 */
public class LockConditionDemo {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition =lock.newCondition();

        ThreadWait threadWait = new ThreadWait(lock , condition);
        threadWait.start();

        ThreadNotify threadNotify = new ThreadNotify(lock,condition);
        threadNotify.start();

    }
}
