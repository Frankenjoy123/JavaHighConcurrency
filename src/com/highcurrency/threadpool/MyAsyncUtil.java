package com.highcurrency.threadpool;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


public class MyAsyncUtil {

    private static final int coreSize = Runtime.getRuntime().availableProcessors() * 50; // 4 processes mean 200 threads
    private static final int maxSize = coreSize * 2; // 400 threads
    private static final int maxQueueSize = maxSize * 10; // 4000 queue size

    /**
     * 平均每秒任务数量 * 平均执行等待秒数 / 平均可接受任务处理秒数
     * 假设每秒1000个任务
     */
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            coreSize, maxSize, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(maxQueueSize),
            new MyThreadFactory("MyAsyncUtil"),
            new MyRejectedPolicy());

    public static void executeTask(Runnable command) {
        executorService.execute(command);
    }

    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        try {
            return executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Future<T> submitTask(Callable<T> task) {
        return executorService.submit(task);
    }

    public static void shutdown() {
        try {
            executorService.shutdown();
        } catch (Exception e) {
        }
    }

    public static int getQueueSize() {
        return ((ThreadPoolExecutor) executorService).getQueue().size();
    }

    private static class MyRejectedPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (!executor.isShutdown()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //do nothing
                }
                executor.execute(r);
            }
        }
    }
}
