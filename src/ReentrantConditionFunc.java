package com.highcurrency.pattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/28.
 */
public class ReentrantConditionFunc implements Runnable{

    private static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static Condition condition = reentrantLock.newCondition();


    @Override
    public void run() {

        reentrantLock.lock();


        try {

            condition.await();

            Thread.sleep(2000);

            System.out.println("work thread done : "+ System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args){


        Thread thread = new Thread(new ReentrantConditionFunc(),"xiaowu-worker-thread");
        thread.start();

        try {

            reentrantLock.lock();
            System.out.println("main thread start : " +System.currentTimeMillis());
        }finally {

            condition.signal();
            reentrantLock.unlock();
        }

    }
}
