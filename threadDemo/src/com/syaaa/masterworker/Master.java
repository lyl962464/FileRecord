package com.syaaa.masterworker;

import java.util.HashMap;
import java.util.Map;
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

        /*每一个worker 对象都需要有Maste对象的引用，workQueue用户任务的领取，resultMap用于任务的提交*/
        worker.setWorkQueue(this.workQueue);
        worker.setResultMap(this.resultMap);

        for (int i = 0; i < workCount; i++) {
            workers.put("子节点"+Integer.toString(i), new Thread(worker));
        }


    }

    /*5、定义任务的提交方法*/

    public void submit(Task task){
        this.workQueue.add(task);
    }

    /*6、定义worker的执行方法*/

    public  void execute(){
        /*遍历workers容器中的每一个worker 并进行启动*/
        for(Map.Entry<String,Thread> me :workers.entrySet()){
            me.getValue().start();
        }
    }

    /*判断线程是否执行完毕*/

    public boolean isComplate() {
        for(Map.Entry<String,Thread> me :workers.entrySet()){

            if (me.getValue().getState()!=Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }


    /*返回结果集*/

    public int getResult() {
        int res =0;
        for(Map.Entry<String,Object> me :resultMap.entrySet()){
           res += (Integer) me.getValue();
        }
        return res;
    }
}
