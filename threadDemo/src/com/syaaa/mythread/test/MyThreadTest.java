package com.syaaa.mythread.test;

import com.syaaa.mythread.MyThread;

/**MyThread的测试类
 * @author syaaa
 * @version 1.0
 * @date 11:09   2018/11/12
 **/
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
        /***
         * 运行结果为：
         *
         * 运行结束
         * MyThread
         *
         *
         * MyThread.java类中的run方法执行的时间比较晚，说明再使用多线程技术时，
         * 代码的运行结果与代码执行顺序或调用顺序是无关的
         *
         * 线程是一个子任务，CPU以不确定的方式，或者说是以随机的方式来调用线程中的run方法
         *
         *
         */



    }
}
