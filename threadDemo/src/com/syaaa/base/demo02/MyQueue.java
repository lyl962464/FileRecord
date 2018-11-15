package com.syaaa.base.demo02;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟Queue
 *
 * @author syaaa
 * @version 1.0
 * @date 14:29   2018/11/13
 **/
public class MyQueue {

    /**
     * 定义存放元素的集合
     */
    private final  LinkedList<Object> list = new LinkedList<>();
    /**
     * 保证累加次数的原子性
     */
    private final  AtomicInteger count = new AtomicInteger();

    private final int maxSize;

    private final  int minSize = 0;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;

    }

    /***
     * 存放数据的方法
     * @param object
     */
    public void put(Object object) {
        lock.lock();
        try {
            /*定义的集合容量和存放的个数相等的时候*/
            while (count.get() == maxSize) {
                condition.await();
            }

            list.add(object);
            /*做累加的操作*/
            count.getAndIncrement();
            System.out.println("元素"+object+"添加到集合中");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public Object take(){
        Object tmp = null;
        lock.lock();
        try {
            while (count.get() == minSize) {
                condition.await();
            }
            /*进行累减的操作*/
            count.getAndIncrement();
            tmp = list.removeFirst();
            System.out.println("元素"+tmp+"被取出");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return tmp;

    }
    public int size(){
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
     final MyQueue m = new MyQueue(5);


        m.put("a");
        m.put("b");
        m.put("c");
        m.put("d");
        m.put("e");

    System.out.println("当前元素的个数为："+m.size());


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.put("h");
                m.put("i");
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Object t1 = m.take();
                    System.out.println("被取走的元素为：" + t1);
                    Thread.sleep(1000);
                    Object t2 = m.take();
                    System.out.println("被取走的元素为：" + t2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
