package com.highcurrency.lock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/14.
 */
public class DeadLock extends Thread{

    //哲学家吃饭需要的刀叉
    static Object fork1 = new Object();

    static Object fork2 = new Object();


    private Object tool;


    public DeadLock(Object object) {

        this.tool = object;

        if (tool == fork1){
            this.setName("哲学家1");
        }else if (tool == fork2){
            this.setName("哲学家2");
        }

    }

    @Override
    public void run() {

        if (tool == fork1){

            synchronized (fork1){
                try {
                    System.out.println("哲学家1开始准备，有了一把叉子1");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork2){
                    System.out.println("哲学家1开始吃饭，有了两把叉子");
                }
            }

        }

        if(tool == fork2){

            synchronized (fork2){

                try {
                    System.out.println("哲学家2开始准备，有了一把叉子2");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork1){
                    System.out.println("哲学家2开始吃饭，有了两把叉子");
                }
            }


        }

    }


    public static void main(String[] args) throws InterruptedException {


        DeadLock deadLock1 = new DeadLock(fork1);

        DeadLock deadLock2 = new DeadLock(fork2);

        deadLock1.start();

        deadLock2.start();


        while (true){

        }


    }
}
