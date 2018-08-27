package com.highcurrency;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/17.
 */
public class Test1 {

    public static void main(String[] args){
        //空格分隔
        System. out .println( "Program arguments" );
        for ( String str:args ){
            System. out .println( str );
        }

        System. out .println( "VM arguments" );
        String syspro1 = "java.util.logging.config.file" ;
        System. out .println( System.getProperty (syspro1) );
        String syspro2 = "cc" ;
        System. out .println( System.getProperty (syspro2) );
    }
}
