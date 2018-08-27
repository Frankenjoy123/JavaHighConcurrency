package com.highcurrency.future.entity;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/16.
 */
public class RealData implements Callable<String>{

    private String param;


    public RealData(String param) {
        this.param = param;
    }



    @Override
    public String call() throws Exception {

        StringBuilder sb = new StringBuilder(param);
        for (int i=0 ; i<10 ;i++){
            sb.append(i);
            Thread.sleep(100);
        }

        return sb.toString();
    }

}
