package com.syaaa.mythread;

/**
 * 验证线程的随机性
 *
 * @author syaaa
 * @version 1.0
 * @date 11:08   2018/11/12
 **/
public class MyThread1 extends  Thread {
    @Override
    public void run() {
        int size = 10;
        for (int i = 0; i < size; i++) {

            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
                System.out.println("run ="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
