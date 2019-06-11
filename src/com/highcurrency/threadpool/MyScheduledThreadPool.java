package com.highcurrency.threadpool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaowu.zhou on 2019/6/11.
 */
public class MyScheduledThreadPool {

    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("Flow Loader-pool-%d").daemon(true).build());


    //提供给spring init-method
    //最小周期1分钟
    public void init() {
        executorService.scheduleAtFixedRate(this::doWork, 0,
                60000, TimeUnit.MILLISECONDS);
    }

    private void doWork(){

        try {
            Thread.sleep(100);
            System.out.println("work done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
