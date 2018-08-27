package com.highcurrency.function;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public interface IAnimal {

    default void breath(){
        System.out.println("Animal breath");
    }

}
