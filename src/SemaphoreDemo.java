package com.highcurrency.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/28.
 */
public class SemaphoreDemo implements Runnable{

    private static Semaphore semaphore = new Semaphore(5);


    @Override
    public void run() {

        try {
            semaphore.acquire();

            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println("thread name " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i=0;i<20;i++){
            executorService.submit(new SemaphoreDemo());
        }

    }


}
