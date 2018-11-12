package com.syaaa.myrunnable.test;

import com.syaaa.myrunnable.MyRunnable;

/**
 * @author syaaa
 * @version 1.0
 * @date 11:52   2018/11/12
 **/
public class MyRunnableTest {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);

        thread.start();
        System.out.println("运行结束");
    }
}
