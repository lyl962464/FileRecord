package com.syaaa.masterworker;

/**
 * @author syaaa
 * @version 1.0
 * @date 17:04   2018/11/3
 **/
public class Worker1 extends Worker {

        public static Object handleTask(Task input) {
            Object output = null;

            try {
                /*表示处理task任务所用的时间，可能是数据的加工，也可能是操作数据库*/
                Thread.sleep(500);
                output = input.getPrice();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return output;
    }




}


