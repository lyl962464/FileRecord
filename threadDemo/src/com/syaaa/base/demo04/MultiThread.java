package com.syaaa.base.demo04;

/**
 *
 * 关键字synchroized   取得的锁都是对象锁，而不是把一段代码（方法）当成锁。
 *
 *所以代码中哪个线程先执行synchronized 关键字的方法，哪个线程就持有该方法所属的锁（Lock）
 *
 *
 *在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）
 *
 *
 *
 * @author syaaa
 * @version 1.0
 * @date 13:46   2018/11/20
 **/
public class MultiThread extends Thread {

    private int num =0;


    /**
     * @author syaaa
     * @date 13:51 2018/11/20
     * @param [args]
     * @return void
     **/
    private synchronized void printNum(String tag){
        try {

            if(tag.equals("a")){
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {


        //俩个不同的对象
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        },"t1");



        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        },"t2");

        t1.start();
        t2.start();

    }

}
