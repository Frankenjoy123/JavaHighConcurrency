package com.highcurrency.future.main;

import com.highcurrency.future.entity.RealData;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public class FutureMain {

    public static void main(String[] args){


        FutureTask<String> future = new FutureTask<String>(new RealData("a"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);


        executorService.submit(future);

        System.out.println("请求完毕");


        //模拟其他业务
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            String result = future.get();
            System.out.println("result : " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
