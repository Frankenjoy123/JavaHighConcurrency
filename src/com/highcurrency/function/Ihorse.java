package com.highcurrency.function;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public interface Ihorse {

    void eat();

    default void run(){
        System.out.println("horse run");
    }

}
