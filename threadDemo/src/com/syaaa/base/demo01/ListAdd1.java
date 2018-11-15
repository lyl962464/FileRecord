package com.syaaa.base.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syaaa
 * @version 1.0
 * @date 13:26   2018/11/13
 **/
public class ListAdd1 {

    private volatile static List list = new ArrayList();

    private void add(){
        list.add("demo");
    }

    private int size(){
        return list.size();
    }


    public static void main(String[] args) {

        final ListAdd1 la = new ListAdd1();


        Thread t1 = new Thread(() -> {
            try {
                int size = 10;
                for (int i = 0; i < size; i++) {
                    la.add();
                    System.out.println("当前线程" + Thread.currentThread().getName() + "添加了一个元素....");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true){
                if (la.size() == 5) {
                    System.out.println("当前线程收到通知"+Thread.currentThread().getName()+"list.size() == 5线程停止");
                    throw new RuntimeException();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
