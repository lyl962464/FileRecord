package com.syaaa.base.demo05;

import java.util.*;

/**
 * 多线程使用Vector或者HashTable的示例（简单线程同步问题）
 *
 * @author syaaa
 * @version 1.0
 * @date 9:36   2018/11/21
 **/
public class Tickets {

    public static void main(String[] args) {
// 初始化火车票池并添加火车票；避免线程同步可采用Vector替代ArrayList，HashTable替代HashMap
        final Vector<String> vector = new Vector<>();


//        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());


        /*添加火车票*/

        int size = 100;
        for (int i = 0; i < size; i++) {
            vector.add("火车票" + i);
        }

//        for(Iterator<String> iterator = vector.iterator();iterator.hasNext();){
//            String tickets = iterator.next();
//            vector.remove(20);
//        }

        int count = 10;
        for (int i = 0; i < count; i++) {
            new Thread("线程" + i) {
                @Override
                public void run() {
                    while (true) {
                        if (vector.isEmpty()) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + "------" + vector.remove(0));
                    }
                }
            }.start();
        }


    }
}
