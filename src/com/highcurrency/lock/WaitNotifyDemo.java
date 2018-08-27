package com.highcurrency.lock;

import org.omg.CORBA.OBJ_ADAPTER;
import sun.awt.windows.ThemeReader;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/17.
 */

/**
 * wait notify 需要保证时序，不然会出现wait得不到唤醒的情况
 */
public class WaitNotifyDemo {


    private static final Object lock = new Object();


    static class BoyThread extends Thread{

        @Override
        public void run() {

            //模拟boy迟到 , lock.wait永远不会唤醒
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a boy has already in hotel");

            synchronized (lock){

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("渡过了愉快的夜晚");

            }

        }
    }

    static class GirlThread extends Thread{

        @Override
        public void run() {

//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//               e.printStackTrace();
//            }


            System.out.println(" a girl come to hotel");

            synchronized (lock){
                lock.notifyAll();
            }

        }

    }



    public static void main(String[] args){


        new BoyThread().start();

        new GirlThread().start();


    }
}
