package com.syaaa.base.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syaaa
 * @version 1.0
 * @date 13:41   2018/11/13
 **/
public class ListAdd2 {
    private volatile static List list = new ArrayList();


    private void add() {
        list.add("demo02");
    }

    private int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAdd2 la = new ListAdd2();
        final Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        System.out.println("t1线程启动。。。。。");

                        int size = 10;
                        for (int i = 0; i < size; i++) {
                            la.add();
                            System.out.println("当前线程" + Thread.currentThread().getName() + "添加了一个元素");

                            Thread.sleep(500);
                            if (la.size() == 5) {
                                System.out.println("已经发出唤醒通知。。。。");
                                lock.notify();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t2线程启动。。。。");
                    if (la.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程" + Thread.currentThread().getName() + "收到通知，停止线程");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        t2.start();
        t1.start();
    }

}
