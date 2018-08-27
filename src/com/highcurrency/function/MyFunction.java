package com.highcurrency.function;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
@FunctionalInterface
public interface MyFunction<T> {
    double applyAsDouble(double left, double right);

//    int compare(T o1, T o2);

    boolean equals(Object obj);
}
