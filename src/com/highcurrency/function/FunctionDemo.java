package com.highcurrency.function;

import java.util.function.Function;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public class FunctionDemo {

    public static void main(String[] args){

        //引入局部变量，为final
        final int finalS = 22;
        Function<Integer , Integer> function = (t) -> t* finalS;

        System.out.println(function.apply(3));

    }
}
