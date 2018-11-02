package com.syaaa.masterworker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author syaaa
 * @version 1.0
 * @date 17:28   2018/11/2
 **/
public class Master {

    /*1、设置一个装载任务的集合*/

    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

    /*2、使用HashMap 去承载所有的worker 对象*/

    private HashMap<String, Thread> workers = new HashMap<>();

    /*3、使用一个容器去装载每一个worker对象，并非执行任务的结果集*/

    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    /*4、定义构造方法*/

    public Master(Worker worker,int workCount){

        worker.setWorkQueue(this.workers);
        worker.setResultMap(this.resultMap);

        for (int i = 0; i < workCount; i++) {
            workers.put("子节点"+Integer.toString(i), new Thread(worker));
        }


    }


}
