package com.highcurrency.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/3.
 */
public class AtomicIntegerArrayFunc {

    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

    static class DemoThread implements Runnable{

        @Override
        public void run() {

            for (int i = 0; i<10000 ; i++){

                atomicIntegerArray.getAndIncrement(i%atomicIntegerArray.length());

            }
        }
    }


    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i=0;i<10;i++){
            executorService.submit(new DemoThread());
        }



    }
}
