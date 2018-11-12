package com.syaaa.mythread.test;

import com.syaaa.mythread.MyThread1;

/**
 * 检验线程随机性的代码测试
 *
 * @author syaaa
 * @version 1.0
 * @date 11:20   2018/11/12
 **/
public class MyThread1Test {

    public static void main(String[] args) {

        MyThread1 thread = new MyThread1();
        thread.setName("mythread");
        thread.start();
        int size = 10;

        try {
            for (int i = 0; i < size; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main"+Thread.currentThread().getName());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
