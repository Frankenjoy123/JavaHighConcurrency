package com.highcurrency.threadlocal;

import java.util.concurrent.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2019/2/25.
 */
public class ThreadLocalMain {

    public static final ThreadLocal<String> context = new ThreadLocal<>();


    public static void main(String[] args) {

        int core = Runtime.getRuntime().availableProcessors();

        System.out.println("core : " + core);

        ExecutorService executorService = new ThreadPoolExecutor(core,core,0L, TimeUnit.MILLISECONDS
            ,new LinkedBlockingQueue<>());

        for (int i=0;i<10;i++){
            executorService.submit(new MyTask(i));
        }

    }

    private static class MyTask implements Runnable{

        private int index;

        public MyTask(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            ThreadLocalMain.context.set("hello"+index);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String s = ThreadLocalMain.context.get();
            System.out.println("thread " + index + " ： "+s);


            //todo 业务逻辑

            //在拦截器filter 最后执行remove
            ThreadLocalMain.context.remove();
        }
    }


}
