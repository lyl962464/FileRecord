package com.syaaa.base.demo04;

/**
 *
 * synchronized 的重入
 *
 *
 * @author syaaa
 * @version 1.0
 * @date 9:25   2018/11/21
 **/
public class SyncDubbo1 {

    public synchronized void method1(){
        System.out.println("method1");
        method2();
    }

    public synchronized void method2(){
        System.out.println("method2");
        method3();
    }
    public synchronized void method3(){
        System.out.println("method3");
    }

    public static void main(String[] args) {

        final SyncDubbo1 sd = new SyncDubbo1();
         Thread  t1 = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     sd.method1();
                 }
          },"t1");

         t1.start();
    }




}
