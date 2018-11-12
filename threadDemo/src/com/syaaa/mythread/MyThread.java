package com.syaaa.mythread;

/**
 * 继承Thread 类的线程的实现方式
 *
 * @author syaaa
 * @version 1.0
 * @date 11:08   2018/11/12
 **/
public class MyThread extends  Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
