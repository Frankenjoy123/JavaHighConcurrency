package com.highcurrency.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/17.
 */
public class LockSupportDemo {


    static class BoyThread extends Thread{

        @Override
        public void run() {

            //模拟boy迟到 , girl也会通过LockSupport.unpark唤醒
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a boy has already in hotel");


            LockSupport.park();
            System.out.println("渡过了愉快的夜晚");

        }


    }

    static class GirlThread extends Thread{

        private final Thread unparkThread;

        public GirlThread(Thread unparkThread){

            this.unparkThread = unparkThread;
        }


        @Override
        public void run() {


            System.out.println(" a girl come to hotel");

            LockSupport.unpark(unparkThread);

        }

    }



    public static void main(String[] args){

        BoyThread boyThread = new BoyThread();

        GirlThread girlThread = new GirlThread(boyThread);


        boyThread.start();

        girlThread.start();

    }
}
