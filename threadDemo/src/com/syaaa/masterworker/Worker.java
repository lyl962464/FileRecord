package com.syaaa.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author syaaa
 * @version 1.0
 * @date 17:29   2018/11/2
 **/
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;


    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        while (true) {
            Task input = this.workQueue.poll();
            /*队列中如果没有任务则跳出循环*/
            if(input == null){
                break;
            }
           Object output= Worker1.handleTask(input);
           this.resultMap.put(Integer.toString(input.getId()), output);


        }



    }
    /**
     * 处理每个任务的的方法
     * @author syaaa
     * @date 15:35 2018/11/3
     * @param input
     * @return void
     **/

    public static Object handleTask(Task input) {
        return null;
    }








}
