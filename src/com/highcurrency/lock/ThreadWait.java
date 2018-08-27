package com.highcurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/8/27.
 */
public class ThreadWait extends Thread{

    private Lock lock;
    private Condition condition;

    public ThreadWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        lock.lock();
        System.out.println("ThreadWait id doing something");
        try {
            condition.await();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("ThreadWait is done");
            lock.unlock();
        }
    }

}
