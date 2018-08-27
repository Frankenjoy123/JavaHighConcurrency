package com.highcurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/8/27.
 */
public class ThreadNotify extends Thread{

    private Lock lock;
    private Condition condition;

    public ThreadNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        lock.lock();
        System.out.println("ThreadNotify id doing something");
        try {
            condition.signal();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("ThreadNotify id done");
            lock.unlock();
        }
    }

}
