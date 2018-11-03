package com.syaaa.masterworker;

import java.util.Random;

/**
 * @author syaaa
 * @version 1.0
 * @date 16:05   2018/11/3
 **/
public class Main {

    public static void main(String[] args) {
        System.out.println("当前可用的线程数为："+Runtime.getRuntime().availableProcessors());
        Master master = new Master(new Worker(), Runtime.getRuntime().availableProcessors());

        int size = 100;
        Random random = new Random();

        for (int i = 0; i < size; i++) {

            Task task = new Task();
            task.setId(i);
            task.setName("name"+i);
            task.setPrice(random.nextInt(1000));
            master.submit(task);

        }

        master.execute();

        long start = System.currentTimeMillis();
        while (true) {
            if(master.isComplate()){
                long time = System.currentTimeMillis() - start;
               int  res =  master.getResult();
                System.out.println("返回的结果集为"+res+",耗时为"+(time/1000)+"秒");
                break;
            }

        }




    }
}

