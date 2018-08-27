package com.highcurrency.function;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public class Mule implements Ihorse , IAnimal , IDonkey{


    @Override
    public void eat() {
        System.out.println("mule eat");
    }

    @Override
    public void run() {
//        Ihorse.super.run();
        IDonkey.super.run();
    }

    public static void main(String[] args){

        Mule mule = new Mule();
        mule.eat();
        mule.breath();
        mule.run();

    }
}
