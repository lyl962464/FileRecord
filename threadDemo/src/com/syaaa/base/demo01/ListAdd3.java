package com.syaaa.base.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author syaaa
 * @version 1.0
 * @date 13:55   2018/11/13
 **/
public class ListAdd3 {
    private volatile static List list = new ArrayList();

    private void add(){
        list.add("demo03");
    }

    private int size(){
        return list.size();
    }

    public static void main(String[] args) {
        ListAdd3 la = new ListAdd3();
        final Lock lock = new ReentrantLock();
        final Condition c = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("t1线程启动。。。。。。。");
                    int size = 10;
                    for (int i = 0; i < size; i++) {
                        la.add();
                        System.out.println("当前线程"+Thread.currentThread().getName()+"添加了一个元素。。。");
                        Thread.sleep(500);

                        if (la.size() == 5) {
                            System.out.println("发出唤醒通知.....");
                            c.signal();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }


            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t2线程启动。。。。。。");
                try {
                    if (la.size() != 5) {
                        c.await();
                    }
                    System.out.println("收到唤醒通知");
                    throw new RuntimeException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        },"t2");

        t2.start();
        t1.start();


    }

}
