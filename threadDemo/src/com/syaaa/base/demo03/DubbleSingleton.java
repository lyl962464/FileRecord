package com.syaaa.base.demo03;

/**
 * 双重验证的单例模式
 *
 * @author syaaa
 * @version 1.0
 * @date 10:25   2018/11/15
 **/
public class DubbleSingleton {

    private static DubbleSingleton singleton;

    public static DubbleSingleton getInstance() {

        if (singleton == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DubbleSingleton.class) {

                /***
                 * 可以选择把if判断取消，会发现同一个对象获取到的hashCode的值不一致
                 * */
                if (singleton == null) {
                    singleton = new DubbleSingleton();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getInstance().hashCode());
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getInstance().hashCode());
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getInstance().hashCode());
            }
        },"t3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(DubbleSingleton.getInstance().hashCode());
            }
        },"t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }















}
